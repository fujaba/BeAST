package de.uks.beast.editor.property.section.sections;

import static de.uks.beast.editor.util.Properties.EXTERNAL_GATEWAY_LABEL;
import static de.uks.beast.editor.util.Properties.ID_LABEL;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.TRANSFER;
import model.Router;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.util.Dimensions;
import de.uks.beast.editor.util.ToolTips;

public class RouterPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(RouterPropertySection.class);
	private Text						ipTextFld;
	private Text						externalGatewayTextFld;
	private Text						idTextFld;
	private Button						submitBtn;
	private Router						router;
	private TransactionalEditingDomain	domain;
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		//Property_ip
		ipTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.ROUTER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE);
		ipTextFld.setToolTipText(ToolTips.IP_PROP_TIP.get());
		ipTextFld.setLayoutData(data);
		
		final CLabel valueLabel = factory.createCLabel(composite, IP_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ipTextFld, valueLabel.getText().length());
		data.top = new FormAttachment(ipTextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		//Property_cpuType
		externalGatewayTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.ROUTER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 25);
		externalGatewayTextFld.setToolTipText(ToolTips.EXT_GATEWAY_PROP_TIP.get());
		externalGatewayTextFld.setLayoutData(data);
		
		final CLabel valueLabe3 = factory.createCLabel(composite, EXTERNAL_GATEWAY_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(externalGatewayTextFld, valueLabe3.getText().length());
		data.top = new FormAttachment(externalGatewayTextFld, 0, SWT.CENTER);
		valueLabe3.setLayoutData(data);
		
		//Property_diskSpace
		idTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.ROUTER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 50);
		idTextFld.setToolTipText(ToolTips.ID_PROP_TIP.get());
		idTextFld.setLayoutData(data);
		
		final CLabel valueLabe5 = factory.createCLabel(composite, ID_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(idTextFld, valueLabe5.getText().length());
		data.top = new FormAttachment(idTextFld, 0, SWT.CENTER);
		valueLabe5.setLayoutData(data);
		
		//Property_submit
		submitBtn = factory.createButton(composite, TRANSFER.get(), 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 125);
		submitBtn.setLayoutData(data);
		submitBtn.setToolTipText(ToolTips.TRANSFER_BTN_TIP.get());
		submitBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						router.setIp(ipTextFld.getText());
						router.setExternalGateway(externalGatewayTextFld.getText());
						router.setId(idTextFld.getText());
						
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
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	private void setPreDefinedValuesToSheet()
	{
		ipTextFld.setText(router.getIp());
		externalGatewayTextFld.setText("" + router.getExternalGateway());
		idTextFld.setText(router.getId());
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
