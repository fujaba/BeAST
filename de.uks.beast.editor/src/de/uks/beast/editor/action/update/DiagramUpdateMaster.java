package de.uks.beast.editor.action.update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.graphiti.internal.services.GraphitiInternal;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.api.kafka.KeyListener;
import de.uks.beast.editor.action.BeASTAction;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;

@SuppressWarnings ("restriction")
public class DiagramUpdateMaster implements KeyListener
{
	private static final Logger							LOGGER	= LogManager.getLogger(RamUsageHandler.class);
	private static final String							LOG		= "LOG";
	
	private final Diagram								diagram;
	private final KafkaLogger							kafkaLogger;
	private final HashMap<String, DiagramUpdateHandler>	updateHandler;
	
	
	
	public DiagramUpdateMaster(final BeASTAction action, final Diagram diagram, final Hardware model)
	{
		this.diagram = diagram;
		this.kafkaLogger = new KafkaLogger(action);
		
		this.updateHandler = new HashMap<String, DiagramUpdateHandler>();
		
		final List<ContainerShape> serverShapes = generateServerShapeList();
		LOGGER.debug("Generate shapeList with " + serverShapes.size() + " server from the editor");
		
		this.updateHandler.put("mem-used", new RamUsageHandler(diagram, model, serverShapes));
		this.updateHandler.put("cpu-used", new CpuUsageHandler(diagram, model, serverShapes));
	}
	
	
	
	@Override
	public String onNewKey(final InstanceInformation info)
	{
		if (info.getKey().equals(LOG))
		{
			kafkaLogger.show(info.getValue());
			
			return "OK";
		}
		
		final DiagramUpdateHandler handler = updateHandler.get(info.getKey());
		
		if (handler != null)
		{
			handler.updateShape(info);
			
			return "OK";
		}
		
		LOGGER.error("Could not find handler for key [" + info.getKey() + "]");
		return "Could not find handler for key [" + info.getKey() + "]";
	}
	
	
	
	public Diagram getDiagram()
	{
		return diagram;
	}
	
	
	
	private List<ContainerShape> generateServerShapeList()
	{
		final List<ContainerShape> shapeList = new ArrayList<>();
		
		for (final Shape shape : getDiagram().getChildren())
		{
//			if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape) instanceof Room)
//			{
//				final Room room = (Room) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
//				
//				if (room != null && GraphitiInternal.getEmfService().isObjectAlive(room))
//				{
//					for (final PictogramLink link : getDiagram().getPictogramLinks())
//					{
//						if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(link.getPictogramElement()) instanceof Server)
//						{
//							final PictogramElement pictogramElement = link.getPictogramElement();
//							
//							if (pictogramElement instanceof ContainerShape)
//							{
//								final ContainerShape serverShape = (ContainerShape) pictogramElement;
//								shapeList.add(serverShape);
//							}
//						}
//					}
//				}
//			}
			/*if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape) instanceof Group)
			{
				final Group group = (Group) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
				
				if (group != null && GraphitiInternal.getEmfService().isObjectAlive(group))
				{
					for (final PictogramLink link : getDiagram().getPictogramLinks())
					{
						if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(link.getPictogramElement()) instanceof Server)
						{
							final PictogramElement pictogramElement = link.getPictogramElement();
							
							if (pictogramElement instanceof ContainerShape)
							{
								final ContainerShape serverShape = (ContainerShape) pictogramElement;
								shapeList.add(serverShape);
							}
						}
					}
				}
			}*/
		}
		
		return shapeList;
	}
	
}
