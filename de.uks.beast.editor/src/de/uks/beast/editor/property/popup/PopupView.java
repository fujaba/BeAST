package de.uks.beast.editor.property.popup;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class PopupView
{
	private Shell			shell;
	private Button			fileBrowserBtn;
	private Text			unzipTargetTextfld;
	private Button			saveBtn;
	private final Display	currentDisplay;
	
	
	
	protected PopupView(final Display display)
	{
		this.currentDisplay = display;
		this.shell = createShell();
		createContent();
	}
	
	
	
	protected boolean isClosed()
	{
		return shell.isDisposed();
	}
	
	
	
	protected Shell createShell()
	{
		return new Shell(currentDisplay, SWT.CLOSE | SWT.TITLE | SWT.MIN);
	}
	
	
	
	protected void reCreateShellAndShow()
	{
		this.shell = createShell();
		createContent();
		show();
	}
	
	
	
	private void createContent()
	{
		final Rectangle boundRect = new Rectangle(0, 0, 400, 100);
		shell.setBounds(boundRect);
		final Rectangle boundInternal = shell.getClientArea();
		
		fileBrowserBtn = new Button(shell, SWT.Selection);
		fileBrowserBtn.setText("Browse");
		fileBrowserBtn.setBounds(boundInternal.x + 20, boundInternal.y + 20, 60, 30);
		
		shell.setText("Fixed size SWT Window.");
		
		unzipTargetTextfld = new Text(shell, SWT.BORDER);
		unzipTargetTextfld.setEditable(true);
		unzipTargetTextfld.setBounds(boundInternal.x + 90, boundInternal.y + 20, 200, 30);
		
		saveBtn = new Button(shell, SWT.Selection);
		saveBtn.setText("�bernehmen");
		saveBtn.setBounds(boundInternal.x + 300, boundInternal.y + 20, 80, 30);
	}
	
	
	
	protected void setFileBrowserBtnListener(final SelectionListener listener)
	{
		if (listener != null)
		{
			fileBrowserBtn.addSelectionListener(listener);
		}
	}
	
	
	
	protected void setSaveBtnListener(final SelectionListener listener)
	{
		if (listener != null)
		{
			saveBtn.addSelectionListener(listener);
		}
	}
	
	
	
	protected String getTextfldInput()
	{
		return unzipTargetTextfld.getText();
	}
	
	
	
	protected boolean isDisposed()
	{
		return shell.isDisposed();
	}
	
	
	
	protected boolean isVisible()
	{
		return shell.isVisible();
	}
	
	
	
	protected void show()
	{
		shell.open();
	}
	
	
	
	protected void close()
	{
		shell.close();
	}
	
}
