package de.uks.beast.editor.properties.section;

import static de.uks.beast.editor.util.Properties.CPU_AMOUNT_LABEL;
import static de.uks.beast.editor.util.Properties.CPU_TYPE_LABEL;
import static de.uks.beast.editor.util.Properties.DISKSPACE_LABEL;
import static de.uks.beast.editor.util.Properties.IP_LABEL;
import static de.uks.beast.editor.util.Properties.RAM_LABEL;
import static de.uks.beast.editor.util.Properties.SUBMIT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Room;
import model.Server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.internal.services.GraphitiInternal;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.Shape;
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

import de.uks.beast.editor.features.util.PropertyUtil;
import de.uks.beast.editor.util.Properties;

public class ServerPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(ServerPropertySection.class);
	private Text						ipTextFld;
	private Text						cpuAmountTextFld;
	private Text						cpuTypeTextFld;
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
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		ipTextFld.setLayoutData(data);
		
		final CLabel valueLabel = factory.createCLabel(composite, IP_LABEL.getProperty());
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
		
		final CLabel valueLabe2 = factory.createCLabel(composite, CPU_AMOUNT_LABEL.getProperty());
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
		
		final CLabel valueLabe3 = factory.createCLabel(composite, CPU_TYPE_LABEL.getProperty());
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
		
		final CLabel valueLabe4 = factory.createCLabel(composite, RAM_LABEL.getProperty());
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
		
		final CLabel valueLabe5 = factory.createCLabel(composite, DISKSPACE_LABEL.getProperty());
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(diskSpaceTextFld, valueLabe5.getText().length());
		data.top = new FormAttachment(diskSpaceTextFld, 0, SWT.CENTER);
		valueLabe5.setLayoutData(data);
		
		//Property_submit
		submitBtn = factory.createButton(composite, SUBMIT.getProperty(), 0);
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
						server.setIp(ipTextFld.getText());
						server.setCpuAmount(Integer.parseInt(cpuAmountTextFld.getText()));
						server.setCpuType(cpuTypeTextFld.getText());
						server.setRam(Integer.parseInt(ramTextFld.getText()));
						server.setDiskSpace(Integer.parseInt(diskSpaceTextFld.getText()));
						
						LOG.debug("server hash: " + server.hashCode() + " -> ip: " + server.getIp());
						LOG.debug("server hash: " + server.hashCode() + " -> cpu amount: " + server.getCpuAmount());
						LOG.debug("server hash: " + server.hashCode() + " -> cpu Type: " + server.getCpuType());
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
		
		//TODO: just for testing
		final Button testBtn = factory.createButton(composite, "TEST", 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, VSPACE + 150);
		testBtn.setLayoutData(data);
		testBtn.addSelectionListener(new SelectionListener() {
			
			@SuppressWarnings ("restriction")
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				for (final Shape shape : getDiagram().getChildren())
				{
					if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape) instanceof Room)
					{
						final Room room = (Room) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(shape);
						
						if (room != null && GraphitiInternal.getEmfService().isObjectAlive(room))
						{
							final Collection<PictogramLink> links = getDiagram().getPictogramLinks();
							
							for (final PictogramLink link : links)
							{
								if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
										link.getPictogramElement()) instanceof Server)
								{
									
									final PictogramElement p = link.getPictogramElement();
									if (p instanceof ContainerShape)
									{
										final List<ContainerShape> serverList = new ArrayList<>();
										
										final Server server = (Server) Graphiti.getLinkService()
												.getBusinessObjectForLinkedPictogramElement(link.getPictogramElement());
										
										final ContainerShape serverShape = (ContainerShape) p;
										serverList.add(serverShape);
										
										for (final Shape sh : serverShape.getChildren())
										{
											if (PropertyUtil.isAttributeShape(sh, Properties.RAM_STAT))
											{
												System.out.println("########## ram textfield of " + serverShape.hashCode());
											}
											else if (PropertyUtil.isAttributeShape(sh, Properties.CPU_STAT))
											{
												System.out.println("########## cpu textfield of " + serverShape.hashCode());
											}
										}
									}
									
								}
								
							}
						}
					}
				}
				
//				
				
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
	
	private final class TestStats implements Runnable
	{
		private final org.eclipse.graphiti.mm.algorithms.Text	text;
		
		
		
		private TestStats(final org.eclipse.graphiti.mm.algorithms.Text text)
		{
			this.text = text;
		}
		
		
		
		@Override
		public void run()
		{
			while (true)
			{
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						int randomNumber = (int) ((Math.random() * 100) + 1);
						text.setValue(String.valueOf(randomNumber));
					}
				});
				
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
