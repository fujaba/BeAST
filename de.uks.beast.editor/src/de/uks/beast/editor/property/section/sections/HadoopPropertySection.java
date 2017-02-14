package de.uks.beast.editor.property.section.sections;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.api.akka.BeastConnection;
import de.uks.beast.editor.property.data.JobDataController;
import de.uks.beast.editor.property.section.views.HadoopPropertyView;
import model.Service;

public class HadoopPropertySection extends GFPropertySection implements ITabbedPropertyConstants
{
	private static final Logger	LOG	= LogManager.getLogger(HadoopPropertySection.class);
	
	private HadoopPropertyView hadoopPropertyView;
	private Service service;
	//private Server server;
	private JobDataController controller;
	
	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		super.createControls(parent, tabbedPropertySheetPage);
		
		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);
		
		controller = new JobDataController(parent.getDisplay(), composite, factory);
		controller.execute();
		LOG.debug("Init JobInformationController...");
	}
	
	@Override
	public void refresh()
	{
		final PictogramElement pe = getSelectedPictogramElement();
		EObject eContainer = pe.eContainer();
		EObject a = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement((PictogramElement) eContainer);

		if (pe != null)
		{
			//server = (Server) a;
			service = (Service) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			//domain = TransactionUtil.getEditingDomain(service);
			//controller.setServerName(server.getName());
			if (service == null)
			{
				return;
			}
			
		}
	}
	
}