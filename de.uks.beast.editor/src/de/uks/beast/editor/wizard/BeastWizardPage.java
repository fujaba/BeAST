package de.uks.beast.editor.wizard;

import static de.uks.beast.editor.util.Strings.BROWSE_BUTTON_TEXT;
import static de.uks.beast.editor.util.Strings.CONTAINER_LABEL;
import static de.uks.beast.editor.util.Strings.DEFAULT_FILENAME;
import static de.uks.beast.editor.util.Strings.FILE_LABEL;
import static de.uks.beast.editor.util.Strings.WIZARD_DESCRIPTION;
import static de.uks.beast.editor.util.Strings.WIZARD_PAGE_NAME;
import static de.uks.beast.editor.util.Strings.WIZARD_TITLE;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import de.uks.beast.editor.util.Strings;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (diagram).
 */

public class BeastWizardPage extends WizardPage
{
	private Text		containerText;
	
	private Text		fileText;
	
	private ISelection	selection;
	
	
	
	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public BeastWizardPage(final ISelection selection)
	{
		super(WIZARD_PAGE_NAME.text());
		setTitle(WIZARD_TITLE.text());
		setDescription(WIZARD_DESCRIPTION.description());
		this.selection = selection;
	}
	
	
	
	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(final Composite parent)
	{
		final Composite container = new Composite(parent, SWT.NULL);
		final GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText(CONTAINER_LABEL.text());
		
		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e)
			{
				dialogChanged();
			}
		});
		
		final Button button = new Button(container, SWT.PUSH);
		button.setText(BROWSE_BUTTON_TEXT.text());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e)
			{
				handleBrowse();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText(FILE_LABEL.text());
		
		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		fileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e)
			{
				dialogChanged();
			}
		});
		initialize();
		dialogChanged();
		setControl(container);
	}
	
	
	
	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */
	
	private void initialize()
	{
		if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection)
		{
			final IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
			{
				return;
			}
			final Object obj = ssel.getFirstElement();
			if (obj instanceof IResource)
			{
				final IContainer container;
				if (obj instanceof IContainer)
				{
					container = (IContainer) obj;
				}
				else
				{
					container = ((IResource) obj).getParent();
				}
				containerText.setText(container.getFullPath().toString());
			}
		}
		fileText.setText(DEFAULT_FILENAME.text() + Strings.FILE_ENDING.text());
	}
	
	
	
	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 */
	
	private void handleBrowse()
	{
		final ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(),
				false, "Select new file container");
		if (dialog.open() == ContainerSelectionDialog.OK)
		{
			final Object[] result = dialog.getResult();
			if (result.length == 1)
			{
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}
	
	
	
	/**
	 * Ensures that both text fields are set.
	 */
	
	private void dialogChanged()
	{
		final IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
		final String fileName = getFileName();
		
		if (getContainerName().length() == 0)
		{
			updateStatus("File container must be specified");
			return;
		}
		if (container == null || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0)
		{
			updateStatus("File container must exist");
			return;
		}
		if (!container.isAccessible())
		{
			updateStatus("Project must be writable");
			return;
		}
		if (fileName.length() == 0)
		{
			updateStatus("File name must be specified");
			return;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0)
		{
			updateStatus("File name must be valid");
			return;
		}
		final int dotLoc = fileName.lastIndexOf('.');
		if (dotLoc != -1)
		{
			final String ext = fileName.substring(dotLoc + 1);
			if (ext.equalsIgnoreCase(Strings.FILE_TYPE.text()) == false)
			{
				updateStatus("File extension must be " + Strings.FILE_ENDING.text());
				return;
			}
		}
		updateStatus(null);
	}
	
	
	
	private void updateStatus(final String message)
	{
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
	
	
	public String getContainerName()
	{
		return containerText.getText();
	}
	
	
	
	public String getFileName()
	{
		return fileText.getText();
	}
}
