package de.uks.beast.editor.property.section;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import de.uks.beast.editor.property.popup.PopupController;
import de.uks.beast.editor.property.popup.PopupController.Status;
import de.uks.beast.editor.service.job.Job;
import de.uks.beast.editor.service.job.JobFile;
import de.uks.beast.editor.service.job.JobInterface;
import de.uks.beast.editor.util.EclipseJobSynchronizer;
import de.uks.beast.editor.util.FileBrowser;
import de.uks.beast.editor.util.ToolTips;

public class HadoopPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger			LOG	= LogManager.getLogger(HadoopPropertySection.class);
	private TransactionalEditingDomain	domain;
	
	//private Path						jobPath;
	private Path						homeOutputPath;
	private List<Path>					inputPathes;
	
	
	
	public HadoopPropertySection()
	{
		inputPathes = new ArrayList<>();
	}
	
	
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final PopupController popupController = new PopupController(parent.getDisplay());
		
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
		nameTextFld.setLayoutData(data);
		nameTextFld.setToolTipText(ToolTips.NAME_TEXT_TIP.get());
		
		final CLabel priorityLabel = factory.createCLabel(composite, "Priority:");
		data = new FormData();
		data.left = new FormAttachment(nameTextFld, 0);
		data.right = new FormAttachment(6, 0);
		data.top = new FormAttachment(0, 0);
		priorityLabel.setLayoutData(data);
		
		final CCombo priorityCombo = factory.createCCombo(composite);
		priorityCombo.setItems(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", });
		priorityCombo.setEditable(false);
		data = new FormData();
		data.left = new FormAttachment(priorityLabel, 0);
		data.right = new FormAttachment(7, -10);
		data.top = new FormAttachment(0, 0);
		priorityCombo.setLayoutData(data);
		priorityCombo.setToolTipText(ToolTips.PRIORITY_COMBO_TIP.get());
		
		final Button runStateBtn = factory.createButton(composite, "Run immediately", SWT.CHECK);
		runStateBtn.setAlignment(SWT.LEFT);
		data = new FormData();
		data.left = new FormAttachment(priorityCombo, 10);
		data.right = new FormAttachment(10, 0);
		data.top = new FormAttachment(0, 0);
		runStateBtn.setLayoutData(data);
		runStateBtn.setToolTipText(ToolTips.RUN_STATE_CHECK_BTN_TIP.get());
		
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
		jobFileTextFld.setEditable(false);
		jobFileTextFld.setLayoutData(data);
		
		//Button for jobFile
		final Button jobFileBtn = factory.createButton(composite, "Job file", 0);
		data = new FormData();
		data.left = new FormAttachment(jobFileTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(nameLabel, -1);
		jobFileBtn.setLayoutData(data);
		jobFileBtn.setToolTipText(ToolTips.JOB_FILE_BTN_TIP.get());
		jobFileBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				if (Status.SUCCES.equals(popupController.interactWithFileBrowser()))
				{
					jobFileTextFld.setText(popupController.getJobFileInfo());
				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
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
		inputFileTextFld.setEditable(false);
		inputFileTextFld.setLayoutData(data);
		
		final Button inputFilesBtn = factory.createButton(composite, "Input files", 0);
		data = new FormData();
		data.left = new FormAttachment(inputFileTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(jobFileLabel, -1);
		inputFilesBtn.setLayoutData(data);
		inputFilesBtn.setToolTipText(ToolTips.INPUT_FILE_BTN_TIP.get());
		inputFilesBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				popupController.showPopup();
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
		outputFileHomeTextFld.setEditable(false);
		outputFileHomeTextFld.setLayoutData(data);
		
		final Button outputFileBtn = factory.createButton(composite, "Output file", 0);
		data = new FormData();
		data.left = new FormAttachment(outputFileHomeTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(inputFileTextFld, -1);
		outputFileBtn.setLayoutData(data);
		outputFileBtn.setToolTipText(ToolTips.HOME_OUTPUT_FILE_BTN.get());
		outputFileBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
//				final FileBrowser fileBrowser = new FileBrowser();
//				fileBrowser.openFileDialog();
//				
//				if (fileBrowser.getFileList().size() == 1)
//				{
//					homeOutputPath = fileBrowser.getFileList().get(0);
//					outputFileHomeTextFld.setText(homeOutputPath.toString());
//				}
//				else
//				{
//					throw new RuntimeException("It is just allowd to select ONE outputFile!");
//				}
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
			}
		});
		
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
		outputFileExtTextFld.setEditable(false);
		outputFileExtTextFld.setLayoutData(data);
		outputFileExtTextFld.setToolTipText(ToolTips.EXT_OUTPUT_FILE_TIP.get());
		outputFileExtTextFld.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent arg0)
			{
				//extOutputPath = Paths.get(outputFileExtTextFld.getText());
			}
		});
		
		//Button for job transfer
		final Button transferBtn = factory.createButton(composite, "Job transfer", 0);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(2, 0);
		data.top = new FormAttachment(outputExtFileLabel, 30);
		transferBtn.setLayoutData(data);
		transferBtn.setToolTipText(ToolTips.JOB_TRANSFER_BTN_TIP.get());
		transferBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				
				try
				{
//					final String name = nameTextFld.getText().isEmpty() ? "default" : nameTextFld.getText();
//					//@formatter:off
//					final Job buildedJob = Job.builder()
//						  .setName(name)
//						  .setJobFile(new JobFile(jobPath.getFileName().toString(), jobPath, Paths.get("")))
//						  .setOutputFile(new JobFile(homeOutputPath.getFileName().toString(), homeOutputPath, Paths.get("")))
//						  .addInputFilesFromPaths(inputPathes)
//						  .build();
//					//@formatter:on
//					
//					printJob(buildedJob);
					
					final EclipseJobSynchronizer jobSynchronizer = new EclipseJobSynchronizer(parent.getShell(), popupController
							.getJob());
					jobSynchronizer.initAndRun();
					
				}
				catch (final Exception e)
				{
					throw new RuntimeException("Error while building or zipping!", e);
				}
				
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
			}
			
		});
		
		final Button resetBtn = factory.createButton(composite, "Reset", 0);
		data = new FormData();
		data.left = new FormAttachment(transferBtn, 0);
		data.right = new FormAttachment(3, 0);
		data.top = new FormAttachment(outputExtFileLabel, 30);
		resetBtn.setLayoutData(data);
		resetBtn.setToolTipText(ToolTips.RESET_BTN_TIP.get());
		resetBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0)
			{
				resetAll();
			}
			
			
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0)
			{
			}
			
			
			
			private void resetAll()
			{
//				nameTextFld.setText("");
//				jobFileTextFld.setText("");
//				inputFileTextFld.setText("");
//				outputFileHomeTextFld.setText("");
//				outputFileExtTextFld.setText("");
//				jobPath = Paths.get("default");
//				inputPathes.clear();
//				homeOutputPath = Paths.get("default");
			}
		});
		
	}
	
	
	
	private void printJob(final Job job)
	{
		LOG.debug("############### <buildedJob> ###############");
		LOG.debug("buildedJob: " + job.getName() + " with " + job.getFileCount() + " files");
		LOG.debug("jobFile: " + job.getJobFile().getPath() + "/" + job.getJobFile().getName());
		for (final JobInterface inputFile : job.getInputFiles())
		{
			LOG.debug("inputFile: " + inputFile.getPath() + "/" + inputFile.getName());
		}
		LOG.debug("outputFile: " + job.getOutputFile().getPath() + "/" + job.getOutputFile().getName());
		LOG.debug("############### </buildedJob> ###############");
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
