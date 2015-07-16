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
	
	
	
	public void show()
	{
		if (!shell.isDisposed())
		{
			shell.open();
		}
		else
		{
			reCreateShellAndShow();
			//shell.setVisible(true);
		}
	}
	
	
	
	public void hide()
	{
		shell.setVisible(false);
	}
	
	
	
	public void close()
	{
		shell.dispose();
	}
	
//	@Override
//	public void update(Observable o, Object arg)
//	{
//		if (arg instanceof Enum)
//		{
//			final Instruction instruction = (Instruction) arg;
//			
//			if (Instruction.CLOSE.equals(instruction))
//			{
//				shell.dispose();
//			}
//			else if (Instruction.OPEN.equals(instruction))
//			{
//				if (!shell.isDisposed())
//				{
//					shell.open();
//				}
//				else
//				{
//					//reCreateShellAndShow();
//					shell.setVisible(true);
//				}
//			}
//			else if (Instruction.HIDE.equals(instruction))
//			{
//				shell.setVisible(false);
//			}
//		}
//	}
	
}
