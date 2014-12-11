package de.uks.beast.editor.properties.section;

import model.Server;

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

public class ServerPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private Text						ipTextFld;
	private Text						cpuAmountTextFld;
	private Text						cpuTypeTextFld;
	private Text						ramTextFld;
	private Text						diskSpaceTextFld;
	private Text						hostTextFld;
	private Button						submitBtn;
	private Server						server;
	private TransactionalEditingDomain	domain;
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		// Property_ip
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
		
		// Property_cpuAmount
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
		
		// Property_cpuType
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
		
		// Property_ram
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
		
		// Property_diskSpace
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
		
		// Property_host
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
		
		//Property_submit
		submitBtn = factory.createButton(composite, "submit", 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, VSPACE + 150);
		submitBtn.setLayoutData(data);
		submitBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						server.setIp(ipTextFld.getText());
						server.setCpuAmount(Integer.parseInt(cpuAmountTextFld.getText()));
						server.setCpuType(cpuTypeTextFld.getText());
						server.setRam(Long.parseLong(ramTextFld.getText()));
						server.setDiskSpace(Long.parseLong(diskSpaceTextFld.getText()));
						server.setHost(hostTextFld.getText());
						
						System.out.println("server hash: " + server.hashCode() + " -> ip: " + server.getIp());
						System.out.println("server hash: " + server.hashCode() + " -> cpu amount: " + server.getCpuAmount());
						System.out.println("server hash: " + server.hashCode() + " -> cpu Type: " + server.getCpuType());
						System.out.println("server hash: " + server.hashCode() + " -> ram: " + server.getRam());
						System.out.println("server hash: " + server.hashCode() + " -> diskspace: " + server.getDiskSpace());
						System.out.println("server hash: " + server.hashCode() + " -> host: " + server.getHost());
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
		ipTextFld.setText("" + server.getIp());
		cpuAmountTextFld.setText("" + server.getCpuAmount());
		cpuTypeTextFld.setText("" + server.getCpuType());
		ramTextFld.setText("" + server.getRam());
		diskSpaceTextFld.setText("" + server.getDiskSpace());
		hostTextFld.setText("" + server.getHost());
	}
	
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			server = (Server) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(server);
			setPreDefinedValuesToSheet();
			
			if (server == null)
			{
				return;
			}
			
		}
	}
}
