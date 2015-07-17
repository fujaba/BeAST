package de.uks.beast.editor.property.popup;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.uks.beast.editor.property.data.Instruction;

public class PopupView implements Observer
{
	private Shell			shell;
	private Button			fileBrowserBtn;
	private Text			unzipTargetTextfld;
	private Button			saveBtn;
	private final Display	currentDisplay;
	
	
	
	public PopupView(final Display display)
	{
		this.currentDisplay = display;
		this.shell = createShell();
		createContent();
	}
	
	
	
	private Shell createShell()
	{
		return new Shell(currentDisplay, SWT.CLOSE | SWT.TITLE | SWT.MIN);
	}
	
	
	
	private void reCreateShellAndShow()
	{
		shell = createShell();
		createContent();
		shell.open();
	}
	
	
	
	private void createContent()
	{
		final Rectangle boundRect = new Rectangle(300, 300, 400, 100);
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
		saveBtn.setText("Übernehmen");
		saveBtn.setBounds(boundInternal.x + 300, boundInternal.y + 20, 80, 30);
	}
	
	
	
	public void setFileBrowserBtnListener(final SelectionListener listener)
	{
		if (listener != null)
		{
			fileBrowserBtn.addSelectionListener(listener);
		}
	}
	
	
	
	public void setSaveBtnListener(final SelectionListener listener)
	{
		if (listener != null)
		{
			saveBtn.addSelectionListener(listener);
		}
	}
	
	
	
	public String getTextfldInput()
	{
		return unzipTargetTextfld.getText();
	}
	
	
	
	@Override
	public void update(Observable o, Object arg)
	{
		if (arg instanceof Enum)
		{
			final Instruction instruction = (Instruction) arg;
			
			if (Instruction.CLOSE.equals(instruction))
			{
				shell.dispose();
			}
			else if (Instruction.OPEN.equals(instruction))
			{
				if (!shell.isDisposed())
				{
					shell.open();
				}
				else
				{
					reCreateShellAndShow();
				}
			}
		}
	}
	
}
