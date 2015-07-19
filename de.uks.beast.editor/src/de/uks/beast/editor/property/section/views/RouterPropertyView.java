package de.uks.beast.editor.property.section.views;

import static de.uks.beast.editor.util.Properties.EXTERNAL_GATEWAY_LABEL;
import static de.uks.beast.editor.util.Properties.ID_LABEL;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.TRANSFER;

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
import de.uks.beast.editor.util.ToolTips;

public class RouterPropertyView
{
	private Text	ipTextFld;
	private Text	externalGatewayTextFld;
	private Text	idTextFld;
	private Button	submitBtn;
	
	
	
	public RouterPropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		createContent(parent, factory);
	}
	
	
	
	private void createContent(final Composite composite, final TabbedPropertySheetWidgetFactory factory)
	{
		FormData data;
		
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
	
	
	
	public String getIpInput()
	{
		return ipTextFld.getText();
	}
	
	
	
	public String getIdInput()
	{
		return idTextFld.getText();
	}
	
	
	
	public String getExternalGatewayInput()
	{
		return externalGatewayTextFld.getText();
	}
	
	
	
	public void setIpInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			ipTextFld.setText(input);
		}
	}
	
	
	
	public void setIdInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			idTextFld.setText(input);
		}
	}
	
	
	
	public void setExternalGatewayInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			externalGatewayTextFld.setText(input);
		}
	}
	
}
