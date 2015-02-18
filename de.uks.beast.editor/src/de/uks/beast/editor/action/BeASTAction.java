package de.uks.beast.editor.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Server;
import model.impl.NetworkImpl;

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
import de.uks.beast.api.kafka.KafkaListener;
import de.uks.beast.editor.action.update.DiagramUpdateMaster;
import de.uks.beast.editor.provider.EditorDiagramTypeProvider;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.Network;

public class BeASTAction implements IObjectActionDelegate
{

	private IStructuredSelection	selection;
	private Shell					shell;
	private MessageConsoleStream consoleStream;
	
	@Override
	public void run(final IAction action)
	{
		Hardware hw = new Hardware();
		
		//parse diagram
		Diagram diagram = EditorDiagramTypeProvider.getCurrentDiagram();
		EList<Shape> children = diagram.getChildren();
		for (Shape shape : children) {
			EObject roomOrNetwork = shape.getLink().getBusinessObjects().get(0);
			
			if (roomOrNetwork instanceof NetworkImpl) {
				NetworkImpl network = (NetworkImpl) roomOrNetwork;
				
				Network net = new Network();
				net.setGateway(network.getGateway());
				net.setIp(network.getIp());
				net.setName(network.getName());
				net.setSubnetmask(network.getSubnetmask());
				net.setDns(network.getDns());
				
				for (Server server : network.getServer()) {
					de.uks.beast.model.Server s = new de.uks.beast.model.Server();
					s.setCpu(server.getCpuAmount());
					s.setDiskSpace(server.getDiskSpace());
					s.setHost(server.getName());
					s.setRam(server.getRam());
					s.setNetwork(net);
					net.addToServer(s);
				}
				
				hw.addToNetworks(net);
			}
			
		}
		
		//open console
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		MessageConsole console = findConsole("BeAST Session ID (" + dateFormat.format(date) +  ")");
		
		try {
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			IWorkbenchPage page = win.getActivePage();
			IConsoleView view = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
			view.display(console);
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
		this.consoleStream = console.newMessageStream();
		
		printToConsole("Started BeAST session...");
		printToConsole("Connecting to BeAST server 141.51.169.20:4410");
		
		BeastTestScenario test = new BeastTestScenario();
		test.setEnvironment(new TestEnvironment("141.51.169.20", 4410));
		
		printToConsole("Waiting for metadata...");
		String kafkaInfos = test.executeEnvironment(hw);
		printToConsole("Connecting to Kafka...");
		
		String[] metadata = kafkaInfos.split(" ");
		
		DiagramUpdateMaster updateMaster = new DiagramUpdateMaster(this, diagram, hw);
		KafkaListener listener = new KafkaListener(updateMaster, metadata[1].trim(), metadata[0].trim());
		listener.start();
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
	
	public IStructuredSelection getSelection() {
		return selection;
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
	
	public void printToConsole(String message) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		consoleStream.println(dateFormat.format(date) + ": " + message);
	}
	
}
