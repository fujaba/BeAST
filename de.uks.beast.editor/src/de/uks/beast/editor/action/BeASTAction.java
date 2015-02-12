package de.uks.beast.editor.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uks.beast.api.BeastTestScenario;
import de.uks.beast.api.TestEnvironment;
import de.uks.beast.api.kafka.KafkaListener;

public class BeASTAction implements IObjectActionDelegate
{
	private static final Logger		LOG	= LogManager.getLogger(BeASTAction.class);
	private IStructuredSelection	selection;
	private Shell					shell;
	
	
	
	@Override
	public void run(final IAction action)
	{
		final IFile file = (IFile) selection.getFirstElement();
		LOG.debug("Parsing file: " + file.getLocation());
		
		BeastTestScenario test = new BeastTestScenario();
		test.setEnvironment(new TestEnvironment("141.51.169.20", 4410));
		
		LOG.debug("Awaiting metadata ...");
		test.executeEnvironment(file.getLocation().toString());
		LOG.debug("Received metadata: " + test.getInfos());
		
		String[] metadata = test.getInfos().split(" ");
		
		KafkaListener listener = new KafkaListener(metadata[0], metadata[1]);
		listener.start();
		
	}
	
	
	
	@Override
	public void selectionChanged(final IAction action, final ISelection selection)
	{
		this.selection = (IStructuredSelection) selection;
	}
	
	
	
	@Override
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart)
	{
		shell = targetPart.getSite().getShell();
	}
	
	
	
	public Shell getShell()
	{
		return shell;
	}
	
}
