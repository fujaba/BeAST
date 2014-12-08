package de.uks.beast.editor.properties.section;

import model.Network;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;



public class NetworkPropertySection extends GFPropertySection implements
		ITabbedPropertyConstants {
	
	private Text	ipTextFld;
	private Text	subnetTextFld;
	private Text	gatewayTextFld;
	private Text	dnsTextFld;
	private Text	idTextFld;
	private Text	nameTextFld;
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage)
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
		
		final CLabel valueLabel = factory.createCLabel(composite, "IP:");
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
		
		final CLabel valueLabe2 = factory.createCLabel(composite, "Subnet:");
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
		
		final CLabel valueLabe3 = factory.createCLabel(composite, "Gateway:");
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
		
		final CLabel valueLabe4 = factory.createCLabel(composite, "DNS:");
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
		
		final CLabel valueLabe5 = factory.createCLabel(composite, "ID:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(idTextFld, valueLabe5.getText().length());
		data.top = new FormAttachment(idTextFld, 0, SWT.CENTER);
		valueLabe5.setLayoutData(data);
		
		//Property_host
		nameTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 125);
		nameTextFld.setLayoutData(data);
		
		final CLabel valueLabe6 = factory.createCLabel(composite, "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameTextFld, valueLabe6.getText().length());
		data.top = new FormAttachment(nameTextFld, 0, SWT.CENTER);
		valueLabe6.setLayoutData(data);
		
	}
	
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			final Network network = (Network) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a EClass
			if (network == null)
			{
				return;
			}
			
		}
	}

}
