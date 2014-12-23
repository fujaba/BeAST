package de.uks.beast.editor.properties.section;

import model.Network;

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

import static de.uks.beast.editor.features.util.message.Message.*;

public class NetworkPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	
	private Text						ipTextFld;
	private Text						subnetTextFld;
	private Text						gatewayTextFld;
	private Text						dnsTextFld;
	private Text						idTextFld;
	private Button						submitBtn;
	private Network						network;
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
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		ipTextFld.setLayoutData(data);
		
		final CLabel valueLabel = factory.createCLabel(composite, IP_LABEL.text());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ipTextFld, valueLabel.getText().length());
		data.top = new FormAttachment(ipTextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		//Property_cpuAmount
		subnetTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 25);
		subnetTextFld.setLayoutData(data);
		
		final CLabel valueLabe2 = factory.createCLabel(composite, SUBNET_MASK_LABEL.text());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(subnetTextFld, valueLabe2.getText().length());
		data.top = new FormAttachment(subnetTextFld, 0, SWT.CENTER);
		valueLabe2.setLayoutData(data);
		
		//Property_cpuType
		gatewayTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 50);
		gatewayTextFld.setLayoutData(data);
		
		final CLabel valueLabe3 = factory.createCLabel(composite, GATEWAY_LABEL.text());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(gatewayTextFld, valueLabe3.getText().length());
		data.top = new FormAttachment(gatewayTextFld, 0, SWT.CENTER);
		valueLabe3.setLayoutData(data);
		
		//Property_ram
		dnsTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 75);
		dnsTextFld.setLayoutData(data);
		
		final CLabel valueLabe4 = factory.createCLabel(composite, DNS_LABEL.text());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(dnsTextFld, valueLabe4.getText().length());
		data.top = new FormAttachment(dnsTextFld, 0, SWT.CENTER);
		valueLabe4.setLayoutData(data);
		
		//Property_diskSpace
		idTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 100);
		idTextFld.setLayoutData(data);
		
		final CLabel valueLabe5 = factory.createCLabel(composite, ID_LABEL.text());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(idTextFld, valueLabe5.getText().length());
		data.top = new FormAttachment(idTextFld, 0, SWT.CENTER);
		valueLabe5.setLayoutData(data);
		
		//Property_submit
		submitBtn = factory.createButton(composite, SUBMIT.text(), 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, VSPACE + 125);
		submitBtn.setLayoutData(data);
		submitBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						network.setIp(ipTextFld.getText());
						network.setSubnetmask(subnetTextFld.getText());
						network.setGateway(gatewayTextFld.getText());
						network.setDns(dnsTextFld.getText());
						network.setId(idTextFld.getText());
						
						System.out.println("network hash: " + network.hashCode() + " -> ip: " + network.getIp());
						System.out.println("network hash: " + network.hashCode() + " -> subnet: " + network.getSubnetmask());
						System.out.println("network hash: " + network.hashCode() + " -> gateway: " + network.getGateway());
						System.out.println("network hash: " + network.hashCode() + " -> dns: " + network.getDns());
						System.out.println("network hash: " + network.hashCode() + " -> id: " + network.getId());
						System.out.println("network hash: " + network.hashCode() + " -> name: " + network.getName());
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
		ipTextFld.setText(network.getIp());
		subnetTextFld.setText("" + network.getSubnetmask());
		gatewayTextFld.setText(network.getGateway());
		dnsTextFld.setText("" + network.getDns());
		idTextFld.setText("" + network.getId());
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
