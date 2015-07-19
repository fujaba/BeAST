package de.uks.beast.editor.property.section.views;

import static de.uks.beast.editor.util.Properties.DNS_LABEL;
import static de.uks.beast.editor.util.Properties.GATEWAY_LABEL;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.SUBNET_MASK_LABEL;
import static de.uks.beast.editor.util.Properties.TRANSFER;

import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.util.Dimensions;
import de.uks.beast.editor.util.PropertyUtil;
import de.uks.beast.editor.util.ToolTips;

public class NetworkPropertyView
{
	private Text	ipTextFld;
	private Text	subnetTextFld;
	private Text	gatewayTextFld;
	private Text	dnsTextFld;
	private Button	submitBtn;
	
	
	
	public NetworkPropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		createContent(parent, factory);
	}
	
	
	
	private void createContent(final Composite composite, final TabbedPropertySheetWidgetFactory factory)
	{
		FormData data;
		
		//Property_ip
		ipTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.NETWORK_PROP_LABEL_WIDTH);
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
		
		//Property_cpuAmount
		subnetTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.NETWORK_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 25);
		subnetTextFld.setToolTipText(ToolTips.SUBNET_MASK_PROP_TIP.get());
		subnetTextFld.setLayoutData(data);
		
		final CLabel valueLabe2 = factory.createCLabel(composite, SUBNET_MASK_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(subnetTextFld, valueLabe2.getText().length());
		data.top = new FormAttachment(subnetTextFld, 0, SWT.CENTER);
		valueLabe2.setLayoutData(data);
		
		//Property_cpuType
		gatewayTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.NETWORK_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 50);
		gatewayTextFld.setToolTipText(ToolTips.GATEWAY_PROP_TIP.get());
		gatewayTextFld.setLayoutData(data);
		
		final CLabel valueLabe3 = factory.createCLabel(composite, GATEWAY_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(gatewayTextFld, valueLabe3.getText().length());
		data.top = new FormAttachment(gatewayTextFld, 0, SWT.CENTER);
		valueLabe3.setLayoutData(data);
		
		//Property_ram
		dnsTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.NETWORK_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 75);
		dnsTextFld.setToolTipText(ToolTips.DNS_PROP_TIP.get());
		dnsTextFld.setLayoutData(data);
		
		final CLabel valueLabe4 = factory.createCLabel(composite, DNS_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(dnsTextFld, valueLabe4.getText().length());
		data.top = new FormAttachment(dnsTextFld, 0, SWT.CENTER);
		valueLabe4.setLayoutData(data);
		
		//Property_submit
		submitBtn = factory.createButton(composite, TRANSFER.get(), 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 125);
		submitBtn.setLayoutData(data);
		submitBtn.setToolTipText(ToolTips.TRANSFER_BTN_TIP.get());
	}
	
	
	
	public void setListenerToSubmitBtn(final SelectionListener listener)
	{
		submitBtn.addSelectionListener(listener);
	}
	
	
	
	public String getIpInput() throws UnknownHostException
	{
		if (PropertyUtil.validateIp(ipTextFld.getText()))
		{
			return ipTextFld.getText();
		}
		else
		{
			throw new UnknownHostException();
		}
	}
	
	
	
	public String getSubnetInput() throws UnknownHostException
	{
		if (PropertyUtil.validateIp(subnetTextFld.getText()))
		{
			return subnetTextFld.getText();
		}
		else
		{
			throw new UnknownHostException();
		}
	}
	
	
	
	public String getGatewayInput() throws UnknownHostException
	{
		if (PropertyUtil.validateIp(gatewayTextFld.getText()))
		{
			return gatewayTextFld.getText();
		}
		else
		{
			throw new UnknownHostException();
		}
	}
	
	
	
	public String getDnsInput() throws UnknownHostException
	{
		if (PropertyUtil.validateIp(dnsTextFld.getText()))
		{
			return dnsTextFld.getText();
		}
		else
		{
			throw new UnknownHostException();
		}
	}
	
	
	
	public void setIpInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			ipTextFld.setText(input);
		}
	}
	
	
	
	public void setSubnetInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			subnetTextFld.setText(input);
		}
	}
	
	
	
	public void setGatewayInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			gatewayTextFld.setText(input);
		}
	}
	
	
	
	public void setDnsInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			dnsTextFld.setText(input);
		}
	}
}
