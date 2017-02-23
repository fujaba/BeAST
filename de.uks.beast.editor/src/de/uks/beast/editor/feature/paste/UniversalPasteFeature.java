package de.uks.beast.editor.feature.paste;

import model.ModelFactory;
import model.Network;
import model.Service;
import model.impl.HadoopMasterImpl;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

public class UniversalPasteFeature extends AbstractPasteFeature {

	public UniversalPasteFeature(final IFeatureProvider fp) {
		super(fp);
	}

	// TODO: deep copy with n+1 id number
	private Service makeDeepCopy(final Service toCopy) {
		final Service newService;
		if (toCopy instanceof HadoopMasterImpl) {
			newService = ModelFactory.eINSTANCE.createHadoopMaster();
		} else {
			newService = ModelFactory.eINSTANCE.createHadoopSlave();
		}
		newService.setName(toCopy.getName() + "_" + newService.hashCode());
		newService.setLimitCpu(toCopy.getLimitCpu());
		newService.setLimitMem(toCopy.getLimitMem());
		newService.setReservationCpu(toCopy.getReservationCpu());
		newService.setReservationMem(toCopy.getReservationMem());

		return newService;
	}

	// TODO: deep copy with n+1 id number
	private Network makeDeepCopy(final Network toCopy) {
		final Network newNetwork = ModelFactory.eINSTANCE.createNetwork();
		newNetwork.setName(toCopy.getName() + "_" + newNetwork.hashCode());

		return newNetwork;
	}

	@Override
	public void paste(final IPasteContext context) {
		final PictogramElement[] pes = context.getPictogramElements();

		for (final Object object : getFromClipboard()) {
			if (object instanceof Network) {
				final Network newNetwork = makeDeepCopy((Network) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(newNetwork);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
			} else if (object instanceof Service) {
				final Service service = makeDeepCopy((Service) object);
				final AddContext ac = new AddContext();
				ac.setNewObject(service);
				ac.setTargetContainer((Diagram) pes[0]);
				addGraphicalRepresentation(ac, ac.getNewObject());
			}
		}
	}

	@Override
	public boolean canPaste(final IPasteContext context) {
		if (context.getPictogramElements().length != 1 || getFromClipboard() == null
				|| getFromClipboard().length == 0) {
			return false;
		}

		final Object source = getFromClipboard()[0];
		Object target;
		if (context.getPictogramElements()[0].getLink() != null) {
			target = context.getPictogramElements()[0].getLink().getBusinessObjects().get(0);
		} else {
			target = context.getPictogramElements()[0];
		}

		if (source instanceof Service && target instanceof Diagram) {
			return true;
		} else if (source instanceof Network && target instanceof Diagram) {
			return true;
		} else {
			return false;
		}
	}
}
