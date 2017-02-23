package de.uks.beast.editor.property.section.sections;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.property.section.views.NetworkPropertyView;
import model.Network;

public class NetworkPropertySection extends GFPropertySection implements ITabbedPropertyConstants {
	private static final Logger LOG = LogManager.getLogger(NetworkPropertySection.class);
	private Network network;
	private TransactionalEditingDomain domain;
	private NetworkPropertyView networkPropertyView;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);

		networkPropertyView = new NetworkPropertyView(composite, factory);

		addListener();
	}

	private void addListener() {
	}

	private void setPreDefinedValuesToSheet() {
	}

	@Override
	public void refresh() {
		final PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {
			network = (Network) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(network);
			setPreDefinedValuesToSheet();

			if (network == null) {
				return;
			}

		}
	}

}
