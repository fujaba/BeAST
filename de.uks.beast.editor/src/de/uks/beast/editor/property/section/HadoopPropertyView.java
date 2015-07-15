package de.uks.beast.editor.property.section;

import java.nio.file.Path;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.property.popup.InfoContainer;
import de.uks.beast.editor.property.popup.InputFileContainer;
import de.uks.beast.editor.property.popup.Instruction;
import de.uks.beast.editor.util.FileUtil;
import de.uks.beast.editor.util.ToolTips;

public class HadoopPropertyView implements Observer
{
	private static final String						FILE_SEPARATOR	= FileUtil.getSpecificFileSeparator();
	private static final String						EMPTY			= "";
	private final Composite							composite;
	private final TabbedPropertySheetWidgetFactory	factory;
	private Button									jobFileBtn;
	private Button									inputFilesBtn;
	private Button									transferBtn;
	private Button									resetBtn;
	private Text									nameTextFld;
	private Text									jobFileTextFld;
	private Text									inputFileTextFld;
	private Text									outputFileTextFld;
	
	
	
	public HadoopPropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory)
	{
		this.composite = parent;
		this.factory = factory;
		
		createContent();
	}
	
	
	
	private void createContent()
	{
		FormData data;
		
		final CLabel nameLabel = factory.createCLabel(composite, "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(1, 0);
		data.top = new FormAttachment(0, 0);
		nameLabel.setLayoutData(data);
		
		nameTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(nameLabel, 0);
		data.right = new FormAttachment(5, 0);
		data.top = new FormAttachment(0, 0);
		nameTextFld.setLayoutData(data);
		nameTextFld.setToolTipText(ToolTips.NAME_TEXT_TIP.get());
		
		final CLabel jobFileLabel = factory.createCLabel(composite, "Job file:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 60);
		data.top = new FormAttachment(nameLabel, 0);
		jobFileLabel.setLayoutData(data);
		
		jobFileTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(jobFileLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(nameLabel, 0);
		jobFileTextFld.setEditable(false);
		jobFileTextFld.setLayoutData(data);
		
		//Button for jobFile
		jobFileBtn = factory.createButton(composite, "Job file", 0);
		data = new FormData();
		data.left = new FormAttachment(jobFileTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(nameLabel, -1);
		jobFileBtn.setLayoutData(data);
		jobFileBtn.setToolTipText(ToolTips.JOB_FILE_BTN_TIP.get());
		
		final CLabel inputFileLabel = factory.createCLabel(composite, "Input file(s):");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 70);
		data.top = new FormAttachment(jobFileLabel, 0);
		inputFileLabel.setLayoutData(data);
		
		inputFileTextFld = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		data = new FormData();
		data.height = 75;
		data.left = new FormAttachment(inputFileLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(jobFileLabel, 0);
		inputFileTextFld.setEditable(false);
		inputFileTextFld.setLayoutData(data);
		
		inputFilesBtn = factory.createButton(composite, "Input files", 0);
		data = new FormData();
		data.left = new FormAttachment(inputFileTextFld, 0);
		data.right = new FormAttachment(9, 0);
		data.top = new FormAttachment(jobFileLabel, -1);
		inputFilesBtn.setLayoutData(data);
		inputFilesBtn.setToolTipText(ToolTips.INPUT_FILE_BTN_TIP.get());
		
		final CLabel outputFileLabel = factory.createCLabel(composite, "Output file:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(0, 100);
		data.top = new FormAttachment(inputFileTextFld, 0);
		outputFileLabel.setLayoutData(data);
		
		outputFileTextFld = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(outputFileLabel, 0);
		data.right = new FormAttachment(0, 400);
		data.top = new FormAttachment(inputFileTextFld, 0);
		outputFileTextFld.setEditable(true);
		outputFileTextFld.setLayoutData(data);
		
		//Button for job transfer
		transferBtn = factory.createButton(composite, "Job transfer", 0);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(2, 0);
		data.top = new FormAttachment(outputFileLabel, 30);
		transferBtn.setLayoutData(data);
		transferBtn.setToolTipText(ToolTips.JOB_TRANSFER_BTN_TIP.get());
		
		resetBtn = factory.createButton(composite, "Reset", 0);
		data = new FormData();
		data.left = new FormAttachment(transferBtn, 0);
		data.right = new FormAttachment(3, 0);
		data.top = new FormAttachment(outputFileLabel, 30);
		resetBtn.setLayoutData(data);
		resetBtn.setToolTipText(ToolTips.RESET_BTN_TIP.get());
		
	}
	
	
	
	private void resetAll()
	{
		nameTextFld.setText(EMPTY);
		jobFileTextFld.setText(EMPTY);
		inputFileTextFld.setText(EMPTY);
		outputFileTextFld.setText(EMPTY);
		inputFileTextFld.setText(EMPTY);
	}
	
	
	
	public String getNameInput()
	{
		return nameTextFld.getText().isEmpty() ? "default" : nameTextFld.getText();
	}
	
	
	
	public void addHandlerToJobFileBtn(final SelectionListener listener)
	{
		if (listener != null)
		{
			jobFileBtn.addSelectionListener(listener);
		}
	}
	
	
	
	public void addHandlerToInputFilesBtn(final SelectionListener listener)
	{
		if (listener != null)
		{
			inputFilesBtn.addSelectionListener(listener);
		}
	}
	
	
	
	public void addHandlerToTransfereBtn(final SelectionListener listener)
	{
		if (listener != null)
		{
			transferBtn.addSelectionListener(listener);
		}
	}
	
	
	
	public void addHandlerToResetBtn(final SelectionListener listener)
	{
		if (listener != null)
		{
			resetBtn.addSelectionListener(listener);
		}
	}
	
	
	
	@Override
	public void update(Observable o, Object arg)
	{
		
		
//		if (arg instanceof InfoContainer)
//		{
//			final InfoContainer infoContainer = (InfoContainer) arg;
//			
//			if (infoContainer.getJobFilePath() != null)
//			{
//				jobFileTextFld.setText(infoContainer.getJobFilePath() + FILE_SEPARATOR
//						+ infoContainer.getJobFilePath().getFileName());
//			}
//			
//		}
//		else if (arg instanceof InputFileContainer)
//		{
//			final InputFileContainer container = (InputFileContainer) arg;
//			if (container.getInputPaths() != null && !container.getInputPaths().isEmpty())
//			{
//				for (final Path p : container.getInputPaths())
//				{
//					inputFileTextFld.append(p + FILE_SEPARATOR + p.getFileName() + "\n");
//				}
//			}
//		}
//		else if (arg instanceof Enum)
//		{
//			final Instruction instruction = (Instruction) arg;
//			
//			if (Instruction.CLEAR.equals(instruction))
//			{
//				resetAll();
//			}
//		}
	}
	
}
