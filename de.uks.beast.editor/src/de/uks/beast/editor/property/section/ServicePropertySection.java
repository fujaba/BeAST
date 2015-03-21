package de.uks.beast.editor.property.section;

import java.nio.file.Path;
import java.nio.file.Paths;

import model.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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

import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobBuilder;
import de.uks.beast.editor.service.job.JobFile;
import de.uks.beast.editor.service.job.JobOutputFile;
import de.uks.beast.editor.util.FileBrowser;

public class ServicePropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(ServicePropertySection.class);
	private TransactionalEditingDomain	domain;
	private JobBuilder					jobBuilder;
	
	
	
	public ServicePropertySection()
	{
		this.jobBuilder = Job.builder();
		
	}
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		final CLabel nameLabel = factory.createCLabel(composite, "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(1, 0);
		data.top = new FormAttachment(0, 0);
		nameLabel.setLayoutData(data);
		
		final Text nameTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(nameLabel, 0);
		data.right = new FormAttachment(5, 0);
		data.top = new FormAttachment(0, 0);
		//jobFileTextFld.setToolTipText(ToolTips.IP_PROP_TIP.getToolTip());
		nameTextFld.setLayoutData(data);
		
		final CLabel priorityLabel = factory.createCLabel(composite, "Priority:");
		data = new FormData();
		data.left = new FormAttachment(nameTextFld, 0);
		data.right = new FormAttachment(6, 0);
		data.top = new FormAttachment(0, 0);
		priorityLabel.setLayoutData(data);
		
		final CCombo priorityCombo = factory.createCCombo(composite);
		priorityCombo.setItems(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", });
		priorityCombo.setEditable(false);
		priorityCombo.setBounds(50, 50, 150, 65);
		data = new FormData();
		data.left = new FormAttachment(priorityLabel, 0);
		data.right = new FormAttachment(7, -10);
		data.top = new FormAttachment(0, 0);
		priorityCombo.setLayoutData(data);
		
		final Button runStateBtn = factory.createButton(composite, "Run immediately", SWT.CHECK);
		runStateBtn.setAlignment(SWT.LEFT);
		data = new FormData();
		data.left = new FormAttachment(priorityCombo, 10);
		data.right = new FormAttachment(10, 0);
		data.top = new FormAttachment(0, 0);
		runStateBtn.setLayoutData(data);
		
		final CLabel jobFileLabel = factory.createCLabel(composite, "Job file:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 60);
		data.top = new FormAttachment(nameLabel, 0);
		jobFileLabel.setLayoutData(data);
		
		final Text jobFileTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(jobFileLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(nameLabel, 0);
		//jobFileTextFld.setToolTipText(ToolTips.IP_PROP_TIP.getToolTip());
		jobFileTextFld.setEditable(false);
		jobFileTextFld.setLayoutData(data);
		
		//Button for jobFile
		final Button jobFileBtn = factory.createButton(composite, "Job file", 0);
		data = new FormData();
		data.left = new FormAttachment(jobFileTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(nameLabel, -1);
		jobFileBtn.setLayoutData(data);
		jobFileBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				final FileBrowser fileBrowser = new FileBrowser();
				fileBrowser.openFileDialog();
				
				if (fileBrowser.getFileList().size() == 1)
				{
					final Path filePath = fileBrowser.getFileList().get(0);
					jobBuilder.setJobFile(new JobFile(filePath.getFileName().toString(), filePath));
					jobFileTextFld.setText(filePath.toString());
				}
				else
				{
					throw new RuntimeException("It is just allowd to select ONE jobFile!");
				}
				
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		final CLabel inputFileLabel = factory.createCLabel(composite, "Input file(s):");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 70);
		data.top = new FormAttachment(jobFileLabel, 0);
		inputFileLabel.setLayoutData(data);
		
		final Text inputFileTextFld = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		data = new FormData();
		data.height = 75;
		data.left = new FormAttachment(inputFileLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(jobFileLabel, 0);
		//jobFileTextFld.setToolTipText(ToolTips.IP_PROP_TIP.getToolTip());
		inputFileTextFld.setEditable(false);
		inputFileTextFld.setLayoutData(data);
		
		//Button for input files
		final Button inputFilesBtn = factory.createButton(composite, "Input files", 0);
		data = new FormData();
		data.left = new FormAttachment(inputFileTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(jobFileLabel, -1);
		inputFilesBtn.setLayoutData(data);
		inputFilesBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				final FileBrowser fileBrowser = new FileBrowser();
				fileBrowser.openFileDialog();
				
				for (final Path path : fileBrowser.getFileList())
				{
					jobBuilder.addInputFiles(new JobFile(path.getFileName().toString(), path));
					inputFileTextFld.append(path.toString() + "\n");
				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
			}
		});
		
		final CLabel outputFileHomeLabel = factory.createCLabel(composite, "Home output file:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 100);
		data.top = new FormAttachment(inputFileTextFld, 0);
		outputFileHomeLabel.setLayoutData(data);
		
		final Text outputFileHomeTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(outputFileHomeLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(inputFileTextFld, 0);
		//jobFileTextFld.setToolTipText(ToolTips.IP_PROP_TIP.getToolTip());
		outputFileHomeTextFld.setEditable(false);
		outputFileHomeTextFld.setLayoutData(data);
		
		final CLabel outputExtFileLabel = factory.createCLabel(composite, "External output file:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 110);
		data.top = new FormAttachment(outputFileHomeLabel, 0);
		outputExtFileLabel.setLayoutData(data);
		
		final Text outputFileExtTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(outputExtFileLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(outputFileHomeLabel, 0);
		//jobFileTextFld.setToolTipText(ToolTips.IP_PROP_TIP.getToolTip());
		outputFileExtTextFld.setEditable(true);
		outputFileExtTextFld.setLayoutData(data);
		
		//TODO: external path muss später ins object geschrieben werden
		final Button outputFileBtn = factory.createButton(composite, "Output file", 0);
		data = new FormData();
		data.left = new FormAttachment(outputFileHomeTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(inputFileTextFld, -1);
		outputFileBtn.setLayoutData(data);
		outputFileBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				if (!outputFileExtTextFld.getText().isEmpty())
				{
					final FileBrowser fileBrowser = new FileBrowser();
					fileBrowser.openFileDialog();
					
					if (fileBrowser.getFileList().size() == 1)
					{
						final Path filePath = fileBrowser.getFileList().get(0);
						final String extOutputFile = outputFileExtTextFld.getText().isEmpty() ? "/home" : outputFileExtTextFld
								.getText();
						jobBuilder.setOutputFile(new JobOutputFile(filePath.getFileName().toString(), filePath, Paths
								.get(extOutputFile)));
						outputFileHomeTextFld.setText(filePath.toString());
					}
					else
					{
						throw new RuntimeException("It is just allowd to select ONE outputFile!");
					}
				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		//Button for job transfer
		final Button transferBtn = factory.createButton(composite, "Job transfer", 0);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(2, 0);
		data.top = new FormAttachment(outputExtFileLabel, 30);
		transferBtn.setLayoutData(data);
		transferBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				final String name = nameTextFld.getText().isEmpty() ? "default" : nameTextFld.getText();
				final String prio = priorityCombo.getText().isEmpty() ? "0" : priorityCombo.getText();
				final boolean runState = runStateBtn.getSelection();
				
				final Job buildedJob = jobBuilder.setName(name).setPriority(Integer.valueOf(prio)).setRunImmediately(runState)
						.build();
				
				LOG.debug("############### <buildedJob> ###############\n");
				LOG.debug("buildedJob: " + buildedJob.toString());
				LOG.debug("jobFile: " + buildedJob.getJobFile());
				for (final JobFile inputFile : buildedJob.getInputFiles())
				{
					LOG.debug("inputFile: " + inputFile);
				}
				LOG.debug("outputFile: " + buildedJob.getOutputFile());
				LOG.debug("\n############### </buildedJob> ###############");
				
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute()
					{
						//TODO: transfer buildedJob !!!!!!!!!!!!
					}
				});
				
				//reset the builder to for new job creation
				jobBuilder = Job.builder();
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
