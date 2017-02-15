package de.uks.beast.editor.property.section.sections;

import java.net.UnknownHostException;

import model.Network;

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

import de.uks.beast.editor.property.section.views.NetworkPropertyView;

public class NetworkPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(NetworkPropertySection.class);
	private Network						network;
	private TransactionalEditingDomain	domain;
	private NetworkPropertyView			networkPropertyView;
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		
		networkPropertyView = new NetworkPropertyView(composite, factory);
		
		addListener();
	}
	
	
	
	private void addListener()
	{
		networkPropertyView.setListenerToSubmitBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						try
						{
							network.setAtribute_0(networkPropertyView.getAttr_0Input());
							network.setAtribute_1(networkPropertyView.getAttr_1Input());
							
							LOG.debug("network hash: " + network.hashCode() + " -> name: " + network.getName());
							LOG.debug("network hash: " + network.hashCode() + " -> ip: " + network.getAtribute_0());
							LOG.debug("network hash: " + network.hashCode() + " -> subnet: " + network.getAtribute_1());
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
		networkPropertyView.setAttr_0Input(network.getAtribute_0());
		networkPropertyView.setAttr_1Input("" + network.getAtribute_1());
	}
	
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		
		if (pe != null)
		{
			network = (Network) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(network);
			setPreDefinedValuesToSheet();
			
			if (network == null)
			{
				return;
			}
			
		}
	}
	
}
