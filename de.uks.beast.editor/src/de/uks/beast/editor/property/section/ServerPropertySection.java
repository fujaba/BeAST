package de.uks.beast.editor.property.section;

import static de.uks.beast.editor.util.Properties.CPU_CORES_LABEL;
import static de.uks.beast.editor.util.Properties.DISKSPACE_LABEL;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.RAM_LABEL;
import static de.uks.beast.editor.util.Properties.TRANSFER;
import model.Server;

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

public class ServerPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(ServerPropertySection.class);
	private Text						ipTextFld;
	private Text						cpuCoresTextFld;
	private Text						ramTextFld;
	private Text						diskSpaceTextFld;
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
		data.left = new FormAttachment(0, Dimensions.SERVER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE);
		ipTextFld.setLayoutData(data);
		
		final CLabel valueLabel = factory.createCLabel(composite, IP_LABEL.getProperty());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ipTextFld, valueLabel.getText().length());
		data.top = new FormAttachment(ipTextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		// Property_cpuAmount
		cpuCoresTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.SERVER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 25);
		cpuCoresTextFld.setLayoutData(data);
		
		final CLabel valueLabe2 = factory.createCLabel(composite, CPU_CORES_LABEL.getProperty());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(cpuCoresTextFld, valueLabe2.getText().length());
		data.top = new FormAttachment(cpuCoresTextFld, 0, SWT.CENTER);
		valueLabe2.setLayoutData(data);
		
		// Property_ram
		ramTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.SERVER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 50);
		ramTextFld.setLayoutData(data);
		
		final CLabel valueLabe4 = factory.createCLabel(composite, RAM_LABEL.getProperty());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ramTextFld, valueLabe4.getText().length());
		data.top = new FormAttachment(ramTextFld, 0, SWT.CENTER);
		valueLabe4.setLayoutData(data);
		
		// Property_diskSpace
		diskSpaceTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, Dimensions.SERVER_PROP_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 75);
		diskSpaceTextFld.setLayoutData(data);
		
		final CLabel valueLabe5 = factory.createCLabel(composite, DISKSPACE_LABEL.getProperty());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(diskSpaceTextFld, valueLabe5.getText().length());
		data.top = new FormAttachment(diskSpaceTextFld, 0, SWT.CENTER);
		valueLabe5.setLayoutData(data);
		
		//Property_submit
		submitBtn = factory.createButton(composite, TRANSFER.getProperty(), 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, Dimensions.PROP_LINE_VSPACE + 125);
		submitBtn.setLayoutData(data);
		submitBtn.setToolTipText("Transfer data to backend");
		submitBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						server.setIp(ipTextFld.getText());
						server.setCpuCores(Integer.parseInt(cpuCoresTextFld.getText()));
						server.setRam(Integer.parseInt(ramTextFld.getText()));
						server.setDiskSpace(Integer.parseInt(diskSpaceTextFld.getText()));
						
						LOG.debug("server hash: " + server.hashCode() + " -> ip: " + server.getIp());
						LOG.debug("server hash: " + server.hashCode() + " -> cpu amount: " + server.getCpuCores());
						LOG.debug("server hash: " + server.hashCode() + " -> ram: " + server.getRam());
						LOG.debug("server hash: " + server.hashCode() + " -> diskspace: " + server.getDiskSpace());
						LOG.debug("server hash: " + server.hashCode() + " -> host: " + server.getName());
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
		cpuCoresTextFld.setText("" + server.getCpuCores());
		ramTextFld.setText("" + server.getRam());
		diskSpaceTextFld.setText("" + server.getDiskSpace());
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
