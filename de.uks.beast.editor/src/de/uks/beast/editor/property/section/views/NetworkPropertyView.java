package de.uks.beast.editor.property.section.views;

import static de.uks.beast.editor.util.Properties.*;

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
	private Text	attr_0TextFld;
	private Text	attr_1TextFld;
	private Button	submitBtn;
	
	
	
	public NetworkPropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		createContent(parent, factory);
	}
	
	
	
	private void createContent(final Composite composite, final TabbedPropertySheetWidgetFactory factory)
	{
		FormData data;
		
		attr_0TextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.NETWORK_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE);
		attr_0TextFld.setToolTipText(ToolTips.ATTR_0_PROP_TIP.get());
		attr_0TextFld.setLayoutData(data);
		
		final CLabel valueLabel = factory.createCLabel(composite, ATTR_0_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(attr_0TextFld, valueLabel.getText().length());
		data.top = new FormAttachment(attr_0TextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		attr_1TextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.NETWORK_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 25);
		attr_1TextFld.setToolTipText(ToolTips.ATTR_1_PROP_TIP.get());
		attr_1TextFld.setLayoutData(data);
		
		final CLabel valueLabe2 = factory.createCLabel(composite, ATTR_1_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(attr_1TextFld, valueLabe2.getText().length());
		data.top = new FormAttachment(attr_1TextFld, 0, SWT.CENTER);
		valueLabe2.setLayoutData(data);
		
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
	
	
	
	public String getAttr_0Input()
	{
		return attr_0TextFld.getText();
	}
	
	
	
	public String getAttr_1Input() throws UnknownHostException
	{
		return attr_1TextFld.getText();
	}
	
	
	
	public void setAttr_0Input(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			attr_0TextFld.setText(input);
		}
	}
	
	
	
	public void setAttr_1Input(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			attr_1TextFld.setText(input);
		}
	}
	
}
