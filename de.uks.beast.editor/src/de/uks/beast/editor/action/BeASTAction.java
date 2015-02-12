package de.uks.beast.editor.action;

import java.util.Iterator;

import model.Server;
import model.impl.NetworkImpl;
import model.impl.RoomImpl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uks.beast.api.BeastTestScenario;
import de.uks.beast.api.TestEnvironment;
import de.uks.beast.api.kafka.KafkaListener;
import de.uks.beast.editor.Activator;
import de.uks.beast.editor.provider.EditorDiagramTypeProvider;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.Network;

import org.eclipse.graphiti.mm.algorithms.impl.RoundedRectangleImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class BeASTAction implements IObjectActionDelegate
{
	private static final Logger		LOG	= LogManager.getLogger(BeASTAction.class);
	private IStructuredSelection	selection;
	private Shell					shell;
	
	@SuppressWarnings("restriction")
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
		
		/*
		BeastTestScenario test = new BeastTestScenario();
		test.setEnvironment(new TestEnvironment("141.51.169.20", 4410));
		
		LOG.debug("Awaiting metadata ...");
		test.executeEnvironment(file.getLocation().toString());
		LOG.debug("Received metadata: " + test.getInfos());
		
		String[] metadata = test.getInfos().split(" ");
		
		KafkaListener listener = new KafkaListener(metadata[0], metadata[1]);
		listener.start();*/
		
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
	
}
