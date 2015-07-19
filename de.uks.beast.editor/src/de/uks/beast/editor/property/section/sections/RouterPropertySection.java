package de.uks.beast.editor.property.section.sections;

import model.Router;

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

import de.uks.beast.editor.property.section.views.RouterPropertyView;

public class RouterPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(RouterPropertySection.class);
	private RouterPropertyView			routerPropertyView;
	private Router						router;
	private TransactionalEditingDomain	domain;
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		
		routerPropertyView = new RouterPropertyView(composite, factory);
		
		addListener();
	}
	
	
	
	private void addListener()
	{
		routerPropertyView.setListenerToSubmitBtn(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						router.setIp(routerPropertyView.getIpInput());
						router.setExternalGateway(routerPropertyView.getExternalGatewayInput());
						router.setId(routerPropertyView.getIdInput());
						
						LOG.debug("router hash: " + router.hashCode() + " -> ip: " + router.getIp());
						LOG.debug("router hash: " + router.hashCode() + " -> external gateway: " + router.getExternalGateway());
						LOG.debug("router hash: " + router.hashCode() + " -> id: " + router.getId());
						LOG.debug("router hash: " + router.hashCode() + " -> name: " + router.getName());
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
		routerPropertyView.setIpInput(router.getIp());
		routerPropertyView.setExternalGatewayInput("" + router.getExternalGateway());
		routerPropertyView.setIdInput(router.getId());
	}
	
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		
		if (pe != null)
		{
			router = (Router) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(router);
			setPreDefinedValuesToSheet();
			
			if (router == null)
			{
				return;
			}
			
		}
	}
}
