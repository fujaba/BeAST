package de.uks.beast.editor.property.section.sections;

import model.Service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.property.section.views.ServicePropertyView;

public class ServicePropertySection extends GFPropertySection implements ITabbedPropertyConstants {
	private static final Logger LOG = LogManager.getLogger(ServicePropertySection.class);
	private ServicePropertyView servicePropertyView;
	private Service service;
	private TransactionalEditingDomain domain;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		final Composite composite = factory.createFlatFormComposite(parent);

		servicePropertyView = new ServicePropertyView(composite, factory);

		addListener();
	}

	private void addListener() {
		servicePropertyView.setListenerToSubmitBtn(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					public void doExecute() {
						try {
							service.setLimitCpu("" + servicePropertyView.getLimitCpuInput());
							service.setReservationCpu("" + servicePropertyView.getReservationCpuInput());
							service.setLimitMem("" + servicePropertyView.getLimitMemInput());
							service.setReservationMem("" + servicePropertyView.getReservationMemInput());

							LOG.debug("service hash: " + service.hashCode() + " -> name: " + service.getName());
							LOG.debug(
									"service hash: " + service.hashCode() + " -> limit_cpu: " + service.getLimitCpu());
							LOG.debug("service hash: " + service.hashCode() + " -> reservation_cpu: "
									+ service.getReservationCpu());
							LOG.debug(
									"service hash: " + service.hashCode() + " -> limit_mem: " + service.getLimitMem());
							LOG.debug("service hash: " + service.hashCode() + " -> reservation_mem: "
									+ service.getReservationMem());

						} catch (NumberFormatException e) {
							throw new RuntimeException("Just integer values are allowed!", e);
						}
					}
				});

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// Nothing to do!

			}
		});
	}

	private void setPreDefinedValuesToSheet() {
		servicePropertyView.setLimitCpuInput("" + service.getLimitCpu());
		servicePropertyView.setReservationCpuInput("" + service.getReservationCpu());
		servicePropertyView.setLimitMemInput("" + service.getLimitMem());
		servicePropertyView.setReservationMemInput("" + service.getReservationMem());
	}

	@Override
	public void refresh() {
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			service = (Service) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			domain = TransactionUtil.getEditingDomain(service);
			setPreDefinedValuesToSheet();

			if (service == null) {
				return;
			}

		}
	}

}