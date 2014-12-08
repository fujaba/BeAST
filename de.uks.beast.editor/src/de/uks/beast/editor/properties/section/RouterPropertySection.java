package de.uks.beast.editor.properties.section;

import model.Router;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
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

public class RouterPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	
	private Text						ipTextFld;
	private Text						externalGatewayTextFld;
	private Text						idTextFld;
	private Text						nameTextFld;
	private Router						router;
	private TransactionalEditingDomain	domain;
	
	
	
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
		ipTextFld.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0)
			{
				if (!ipTextFld.getText().isEmpty())
				{
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						public void doExecute()
						{
							router.setIp(ipTextFld.getText());
							System.out.println("router hash: " + router.hashCode() + " -> ip: " + router.getIp());
						}
					});
				}
				
			}
		});
		
		final CLabel valueLabel = factory.createCLabel(composite, "IP:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(ipTextFld, valueLabel.getText().length());
		data.top = new FormAttachment(ipTextFld, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		//Property_cpuType
		externalGatewayTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 25);
		externalGatewayTextFld.setLayoutData(data);
		externalGatewayTextFld.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0)
			{
				if (!externalGatewayTextFld.getText().isEmpty())
				{
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						public void doExecute()
						{
							router.setExternalGateway(externalGatewayTextFld.getText());
							System.out.println("router hash: " + router.hashCode() + " -> external Gateway: "
									+ router.getExternalGateway());
						}
					});
				}
				
			}
		});
		
		final CLabel valueLabe3 = factory.createCLabel(composite, "External Gateway:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(externalGatewayTextFld, valueLabe3.getText().length());
		data.top = new FormAttachment(externalGatewayTextFld, 0, SWT.CENTER);
		valueLabe3.setLayoutData(data);
		
		//Property_diskSpace
		idTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE + 50);
		idTextFld.setLayoutData(data);
		idTextFld.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0)
			{
				if (!idTextFld.getText().isEmpty())
				{
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						public void doExecute()
						{
							router.setId(idTextFld.getText());
							System.out.println("router hash: " + router.hashCode() + " -> id: " + router.getId());
						}
					});
				}
				
			}
		});
		
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
		data.top = new FormAttachment(0, VSPACE + 75);
		nameTextFld.setLayoutData(data);
		nameTextFld.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0)
			{
				if (!nameTextFld.getText().isEmpty())
				{
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						public void doExecute()
						{
							router.setName(nameTextFld.getText());
							System.out.println("router hash: " + router.hashCode() + " -> name: " + router.getName());
						}
					});
				}
				
			}
		});
		
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
			router = (Router) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(router);
			if (router == null)
			{
				return;
			}
			
		}
	}
}
