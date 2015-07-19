package de.uks.beast.editor.property.section.sections;

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
						network.setIp(networkPropertyView.getIpInput());
						network.setSubnetmask(networkPropertyView.getSubnetInput());
						network.setGateway(networkPropertyView.getGatewayInput());
						network.setDns(networkPropertyView.getDnsInput());
						
						LOG.debug("network hash: " + network.hashCode() + " -> ip: " + network.getIp());
						LOG.debug("network hash: " + network.hashCode() + " -> subnet: " + network.getSubnetmask());
						LOG.debug("network hash: " + network.hashCode() + " -> gateway: " + network.getGateway());
						LOG.debug("network hash: " + network.hashCode() + " -> dns: " + network.getDns());
						LOG.debug("network hash: " + network.hashCode() + " -> name: " + network.getName());
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
		networkPropertyView.setIpInput(network.getIp());
		networkPropertyView.setSubnetInput("" + network.getSubnetmask());
		networkPropertyView.setGatewayInput(network.getGateway());
		networkPropertyView.setDnsInput("" + network.getDns());
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
