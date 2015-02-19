package de.uks.beast.editor.action.update;

import static de.uks.beast.editor.util.Constants.*;
import model.Rack;
import model.Room;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.impl.GaServiceImpl;

import de.uks.beast.editor.features.util.PropertyUtil;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;
import de.uks.beast.model.Server;

public class MemoryUsedHandler extends DiagramUpdateHandler
{
	
	public MemoryUsedHandler(final Diagram diagram, final Hardware model)
	{
		super(diagram, model);
	}
	
	
	
	@Override
	public void updateShape(final InstanceInformation info)
	{
		final Server server = model.serverFromHostName(info.getHost());
		System.out.println("Update shape from server " + server.getHost() + ";" + " RAM: " + Long.parseLong(info.getValue())
				/ (server.getRam() * 1000000) + "%");
		
		//TODO @Moritz: add code from ServerPropertySection here and handle RAM/CPU handling
		
		//Graphiti.getLinkService().getPictogramElements(diagram, server);
		
		for (final Shape shape : diagram.getChildren())
		{
			
//			final EObject[] objects = Graphiti.getLinkService().getAllBusinessObjectsForLinkedPictogramElement(shape);
//			
//			if (objects[0] instanceof Room)
//			{
//				for (final EObject e : objects[0].eContents())
//				{
//					if (e instanceof Rack)
//					{
//						for (final EObject ee : e.eContents())
//						{
//							if (ee instanceof Server)
//							{
//								for (final PictogramElement pe : Graphiti.getLinkService().getPictogramElements(diagram, ee))
//								{
//									if (PropertyUtil.isAttributeShape(pe, IP))
//									{
//										final Text ipTextField = (Text) pe.getGraphicsAlgorithm();
//										if (ipTextField.getValue().equals(server.getHost()))
//										{
//											
//										}
//									}
//									
//									if (PropertyUtil.isAttributeShape(pe, RAM_STAT))
//									{
//										final Text text = (Text) pe.getGraphicsAlgorithm();
//										
//									}
//								}
//							}
//						}
//					}
//				}
//			}
		}
		
	}
	
}
