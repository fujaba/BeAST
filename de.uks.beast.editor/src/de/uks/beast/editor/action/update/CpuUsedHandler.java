package de.uks.beast.editor.action.update;

import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.uks.beast.model.Hardware;
import de.uks.beast.model.InstanceInformation;
import de.uks.beast.model.Server;

public class CpuUsedHandler extends DiagramUpdateHandler
{
	
	public CpuUsedHandler(final Diagram diagram, final Hardware model)
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
		
	}
	
}
