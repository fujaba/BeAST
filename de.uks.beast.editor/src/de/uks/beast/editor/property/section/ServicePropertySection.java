package de.uks.beast.editor.property.section;

import java.nio.file.Path;

import model.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobBuilder;
import de.uks.beast.editor.service.job.JobFile;
import de.uks.beast.editor.util.FileBrowser;

public class ServicePropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(ServicePropertySection.class);
	private Button						inputFilesBtn;
	private TransactionalEditingDomain	domain;
	private final FileBrowser			fileBrowser;
	private final JobBuilder			jobBuilder;
	
	
	
	public ServicePropertySection()
	{
		this.fileBrowser = new FileBrowser();
		this.jobBuilder = Job.builder();
		
	}
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		//Property_submit
		inputFilesBtn = factory.createButton(composite, "Browse files", 0);
		data = new FormData();
		data.left = new FormAttachment(0, 20);
		data.right = new FormAttachment(20, 0);
		data.top = new FormAttachment(0, VSPACE);
		inputFilesBtn.setLayoutData(data);
		inputFilesBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				
				fileBrowser.openFileDialog();
				
				for (final Path path : fileBrowser.getFileList())
				{
					LOG.debug("Selected file: " + path);
					jobBuilder.addInputFiles(new JobFile(path.getFileName().toString(), path));
				}
				
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						//TODO: submit pathList
					}
				});
				
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
			}
		});
		
	}
	
	
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			final Service service = (Service) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(service);
			
			if (service == null)
			{
				return;
			}
			
		}
	}
	
}
