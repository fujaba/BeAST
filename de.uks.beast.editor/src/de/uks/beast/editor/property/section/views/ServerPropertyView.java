package de.uks.beast.editor.property.section.views;

import static de.uks.beast.editor.util.Properties.DISKSPACE_LABEL;
import static de.uks.beast.editor.util.Properties.RAM_LABEL;
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
import de.uks.beast.editor.util.Properties;
import de.uks.beast.editor.util.PropertyUtil;
import de.uks.beast.editor.util.ToolTips;

public class ServerPropertyView
{
	private Text	ipTextFld;
	private Text	cpuCoresTextFld;
	private Text	ramTextFld;
	private Text	diskSpaceTextFld;
	private Button	submitBtn;
	
	
	
	public ServerPropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		createContent(parent, factory);
	}
	
	
	
	private void createContent(final Composite composite, final TabbedPropertySheetWidgetFactory factory)
	{
		FormData data;
		
		ipTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.SERVICE_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE);
		ipTextFld.setToolTipText(ToolTips.ATTR_0_PROP_TIP.get());
		ipTextFld.setLayoutData(data);
		
		final CLabel valueLabel = factory.createCLabel(composite, Properties.ATTR_0_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ipTextFld, valueLabel.getText().length());
		data.top = new FormAttachment(ipTextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		cpuCoresTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.SERVICE_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 25);
		cpuCoresTextFld.setToolTipText(ToolTips.ATTR_1_PROP_TIP.get());
		cpuCoresTextFld.setLayoutData(data);
		
		final CLabel valueLabe2 = factory.createCLabel(composite, Properties.ATTR_1_LABEL.get());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(cpuCoresTextFld, valueLabe2.getText().length());
		data.top = new FormAttachment(cpuCoresTextFld, 0, SWT.CENTER);
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
	
	
	
	public int getCpuCoresInput() throws NumberFormatException
	{
		return Integer.parseInt(cpuCoresTextFld.getText());
	}
	
	
	
	public int getRamInput() throws NumberFormatException
	{
		return Integer.parseInt(ramTextFld.getText());
	}
	
	
	
	public int getDiskSpaceInput() throws NumberFormatException
	{
		return Integer.parseInt(diskSpaceTextFld.getText());
	}
	
	
	
	public void setIpInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			ipTextFld.setText(input);
		}
	}
	
	
	
	public void setCpuCoresInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			cpuCoresTextFld.setText(input);
		}
	}
	
	
	
	public void setRamInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			ramTextFld.setText(input);
		}
	}
	
	
	
	public void setDiskSpaceInput(final String input)
	{
		if (input != null && !input.isEmpty())
		{
			diskSpaceTextFld.setText(input);
		}
	}
}