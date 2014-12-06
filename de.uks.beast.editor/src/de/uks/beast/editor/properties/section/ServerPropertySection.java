package de.uks.beast.editor.properties.section;

import model.Server;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class ServerPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private Text	ipTextFld;
	private Text	cpuAmountTextFld;
	private Text	cpuTypeTextFld;
	private Text	ramTextFld;
	private Text	diskSpaceTextFld;
	private Text	hostTextFld;
	
	
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		final Server server = getInstance();
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
		ipTextFld.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent arg0) {
				if(!ipTextFld.getText().isEmpty()) {
					System.out.println("########## text input: " + arg0);
				}
				
			}
		});
		
		final CLabel valueLabel = factory.createCLabel(composite, "IP:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ipTextFld, valueLabel.getText().length());
		data.top = new FormAttachment(ipTextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		//Property_cpuAmount
		cpuAmountTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 25);
		cpuAmountTextFld.setLayoutData(data);
		
		final CLabel valueLabe2 = factory.createCLabel(composite, "CPU Amount:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(cpuAmountTextFld, valueLabe2.getText().length());
		data.top = new FormAttachment(cpuAmountTextFld, 0, SWT.CENTER);
		valueLabe2.setLayoutData(data);
		
		//Property_cpuType
		cpuTypeTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 50);
		cpuTypeTextFld.setLayoutData(data);
		
		final CLabel valueLabe3 = factory.createCLabel(composite, "CPU Type:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(cpuTypeTextFld, valueLabe3.getText().length());
		data.top = new FormAttachment(cpuTypeTextFld, 0, SWT.CENTER);
		valueLabe3.setLayoutData(data);
		
		//Property_ram
		ramTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 75);
		ramTextFld.setLayoutData(data);
		
		final CLabel valueLabe4 = factory.createCLabel(composite, "RAM:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ramTextFld, valueLabe4.getText().length());
		data.top = new FormAttachment(ramTextFld, 0, SWT.CENTER);
		valueLabe4.setLayoutData(data);
		
		//Property_diskSpace
		diskSpaceTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 100);
		diskSpaceTextFld.setLayoutData(data);
		
		final CLabel valueLabe5 = factory.createCLabel(composite, "DiskSpace:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(diskSpaceTextFld, valueLabe5.getText().length());
		data.top = new FormAttachment(diskSpaceTextFld, 0, SWT.CENTER);
		valueLabe5.setLayoutData(data);
		
		//Property_host
		hostTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 125);
		hostTextFld.setLayoutData(data);
		
		final CLabel valueLabe6 = factory.createCLabel(composite, "Host:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(hostTextFld, valueLabe6.getText().length());
		data.top = new FormAttachment(hostTextFld, 0, SWT.CENTER);
		valueLabe6.setLayoutData(data);
	}
	
	
	
	
	private Server getInstance() {
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			final Server server = (Server) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			return server;
			
		}
		return null;
	}
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			final Server server = (Server) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a EClass
			if (server == null)
			{
				return;
			}
			
		}
	}
}
