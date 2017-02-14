package de.uks.beast.editor.property.section.sections;

import java.net.UnknownHostException;

import model.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.property.section.views.ServerPropertyView;

public class ServerPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(ServerPropertySection.class);
	private ServerPropertyView			serverPropertyView;
	private Service						service;
	private TransactionalEditingDomain	domain;
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		
		serverPropertyView = new ServerPropertyView(composite, factory);
		
		addListener();
	}
	
	
	
	private void addListener()
	{
		serverPropertyView.setListenerToSubmitBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						try
						{
							service.setAtribute_0("" + serverPropertyView.getIpInput());
							service.setAtribute_1("" + serverPropertyView.getCpuCoresInput());
							
							//LOG.debug("server hash: " + server.hashCode() + " -> ip: " + server.getIp());
							//LOG.debug("server hash: " + server.hashCode() + " -> cpu amount: " + server.getCpuCores());
							//LOG.debug("server hash: " + server.hashCode() + " -> host: " + server.getName());
						}
						catch (NumberFormatException e)
						{
							throw new RuntimeException("Just integer values are allowed!", e);
						}
						catch (UnknownHostException e)
						{
							throw new RuntimeException("Wrong IP format!", e);
						}
					}
				});
				
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// Nothing to do!
				
			}
		});
	}
	
	
	
	private void setPreDefinedValuesToSheet()
	{
		serverPropertyView.setIpInput("" + service.getAtribute_0());
		serverPropertyView.setCpuCoresInput("" + service.getAtribute_1());
	}
	
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			service = (Service) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(service);
			setPreDefinedValuesToSheet();
			
			if (service == null)
			{
				return;
			}
			
		}
	}
	
}