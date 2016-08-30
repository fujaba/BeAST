package de.uks.beast.editor.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.uks.beast.api.BeastTestScenario;
import de.uks.beast.api.TestEnvironment;
import de.uks.beast.api.akka.BeastConnection;
import de.uks.beast.api.kafka.KafkaListener;
import de.uks.beast.editor.action.update.DiagramUpdateMaster;
import de.uks.beast.editor.property.data.JobDataController;
import de.uks.beast.editor.provider.EditorDiagramTypeProvider;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.Network;
import model.Server;
import model.impl.NetworkImpl;

public class BeASTAction implements IObjectActionDelegate
{
	
	private IStructuredSelection	selection;
	private Shell					shell;
	private MessageConsoleStream	consoleStream;
	
	
	
	@Override
	public void run(final IAction action)
	{
		final Hardware hw = new Hardware();
		
		//parse diagram
		final Diagram diagram = EditorDiagramTypeProvider.getCurrentDiagram();
		final EList<Shape> children = diagram.getChildren();
		
		for (final Shape shape : children)
		{
			final EObject roomOrNetwork = shape.getLink().getBusinessObjects().get(0);
			
			if (roomOrNetwork instanceof NetworkImpl)
			{
				final NetworkImpl network = (NetworkImpl) roomOrNetwork;
				
				final Network net = new Network();
				net.setGateway(network.getGateway());
				net.setIp(network.getIp());
				net.setName(network.getName());
				net.setSubnetmask(network.getSubnetmask());
				net.setDns(network.getDns());
				
				for (final Server server : network.getServer())
				{
					final de.uks.beast.model.Server s = new de.uks.beast.model.Server();
					s.setCpu(server.getCpuCores());
					s.setDiskSpace(server.getDiskSpace());
					s.setHost(server.getName());
					s.setIp(server.getIp());
					s.setRam(server.getRam());
					
					if (server.getService() != null) {
						final de.uks.beast.model.Service service = new de.uks.beast.model.Service();
						service.setServiceName(server.getService().getServiceName());
						service.setServiceType(server.getService().getServiceType());
						
						s.setService(service);
					}
					
					s.setNetwork(net);
					net.addToServer(s);
				}
				
				hw.addToNetworks(net);
			}
			
		}
		
		//open console
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final Date date = new Date();
		final MessageConsole console = findConsole("BeAST Session ID (" + dateFormat.format(date) + ")");
		
		try
		{
			final IWorkbench wb = PlatformUI.getWorkbench();
			final IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			final IWorkbenchPage page = win.getActivePage();
			final IConsoleView view = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
			view.display(console);
			
		}
		catch (final PartInitException e)
		{
			e.printStackTrace();
		}
		
		this.consoleStream = console.newMessageStream();
		
		String ip = "127.0.1.1";
		int port = 4410;
		
		printToConsole("Started BeAST session...");
		printToConsole("Connecting to BeAST server " + ip + ":" + port);
		
		final BeastTestScenario test = new BeastTestScenario();
		test.setEnvironment(new TestEnvironment(ip, port));
		
		printToConsole("Waiting for metadata...");
		final BeastConnection con = test.executeEnvironment(hw);
		JobDataController.con = con;
		printToConsole("Connecting to kafka cluster ...");
		
		final String[] metadata = con.getInfo().split(" ");
		
		final DiagramUpdateMaster updateMaster = new DiagramUpdateMaster(this, diagram, hw);
		final KafkaListener listener = new KafkaListener(updateMaster, metadata[1].trim(), metadata[0].trim());
		listener.start();
		
		printToConsole("Connection established, listening on topic: " + metadata[0].trim());
	}
	
	
	
	@Override
	public void selectionChanged(final IAction action, final ISelection selection)
	{
		this.selection = (IStructuredSelection) selection;
	}
	
	
	
	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart)
	{
		shell = targetPart.getSite().getShell();
	}
	
	
	
	public Shell getShell()
	{
		return shell;
	}
	
	
	
	public IStructuredSelection getSelection()
	{
		return selection;
	}
	
	
	
	private MessageConsole findConsole(final String name)
	{
		final ConsolePlugin plugin = ConsolePlugin.getDefault();
		final IConsoleManager conMan = plugin.getConsoleManager();
		final IConsole[] existing = conMan.getConsoles();
		
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		final MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		
		return myConsole;
	}
	
	
	
	public void printToConsole(final String message)
	{
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final Date date = new Date();
		consoleStream.println(dateFormat.format(date) + ": " + message);
	}
	
}
