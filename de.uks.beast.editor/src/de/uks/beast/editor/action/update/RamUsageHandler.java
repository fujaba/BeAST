package de.uks.beast.editor.action.update;

import java.util.List;

import model.Server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import de.uks.beast.editor.features.util.PropertyUtil;
import de.uks.beast.editor.util.Properties;
import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;

public class RamUsageHandler extends DiagramUpdateHandler
{
	private static final Logger			LOG	= LogManager.getLogger(RamUsageHandler.class);
	private final List<ContainerShape>	serverShapes;
	
	
	
	public RamUsageHandler(final Diagram diagram, final Hardware model, final List<ContainerShape> serverShapes)
	{
		super(diagram, model);
		this.serverShapes = serverShapes;
	}
	
	@Override
	public void updateShape(final InstanceInformation info)
	{
		final de.uks.beast.model.Server externalServer = model.serverFromHostName(info.getHost());
		
		String temp = "" + (Double.parseDouble(info.getValue()) * 100);
		final String ramValue = temp.substring(0, temp.indexOf("."));
		
		LOG.debug("Value: " + info.getValue() + ", Total: " + externalServer.getRam());
		
		for (final ContainerShape containerShape : serverShapes)
		{
			final Server serverFromEditor = (Server) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
					containerShape);
			
			if (checkServerEquals(externalServer, serverFromEditor))
			{
				LOG.debug("Update shape from server " + externalServer.getHost() + " with new RAM usage");
				
				final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(serverFromEditor);
				
				for (final Shape shape : containerShape.getChildren())
				{
					if (PropertyUtil.isAttributeShape(shape, Properties.RAM_STAT))
					{
						final Text ramStatText = (Text) shape.getGraphicsAlgorithm();
						
						LOG.debug("Old value from ramStatTextfield: " + ramStatText.getValue());
						domain.getCommandStack().execute(new RecordingCommand(domain) {
							public void doExecute()
							{
								ramStatText.setValue(ramValue);
							}
						});
						LOG.debug("New value from ramStatTextfield: " + ramStatText.getValue());
						
						return;
					}
				}
			}
		}
	}
	
	
	
	private boolean checkServerEquals(final de.uks.beast.model.Server externalServer, final Server serverFromEditor)
	{
		return externalServer.getHost().equals(serverFromEditor.getName())
				&& externalServer.getIp().equals(serverFromEditor.getIp());
	}
	
}
