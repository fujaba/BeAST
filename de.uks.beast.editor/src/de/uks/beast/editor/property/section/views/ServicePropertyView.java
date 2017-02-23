package de.uks.beast.editor.property.section.views;

import static de.uks.beast.editor.property.section.views.NodeFactory.createHBox;
import static de.uks.beast.editor.property.section.views.NodeFactory.createRowData;
import static de.uks.beast.editor.property.section.views.NodeFactory.createVBox;
import static de.uks.beast.editor.util.Properties.LIMIT_CPU_LABEL;
import static de.uks.beast.editor.util.Properties.LIMIT_MEM_LABEL;
import static de.uks.beast.editor.util.Properties.RESERVATION_CPU_LABEL;
import static de.uks.beast.editor.util.Properties.RESERVATION_MEM_LABEL;
import static de.uks.beast.editor.util.Properties.TRANSFER;
import static de.uks.beast.editor.util.ToolTips.LIMIT_CPU_PROP_TIP;
import static de.uks.beast.editor.util.ToolTips.LIMIT_MEM_PROP_TIP;
import static de.uks.beast.editor.util.ToolTips.RESERVATION_CPU_PROP_TIP;
import static de.uks.beast.editor.util.ToolTips.RESERVATION_MEM_PROP_TIP;
import static de.uks.beast.editor.util.ToolTips.TRANSFER_BTN_TIP;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class ServicePropertyView {
	private static final int TEXT_WIDTH = 100;

	private Text limitCpuTextFld;
	private Text reservationCpuTextFld;
	private Text limitMemTextFld;
	private Text reservationMemTextFld;
	private Button submitBtn;

	public ServicePropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory) {
		createContent(parent, factory);
	}

	private void createContent(final Composite composite, final TabbedPropertySheetWidgetFactory factory) {

		final RowLayout vBox = createVBox();
		composite.setLayout(vBox);

		// **************************************************************************
		final RowLayout line_0 = createHBox();

		final Composite c0 = factory.createComposite(composite);
		c0.setLayout(line_0);

		final CLabel label0 = factory.createCLabel(c0, LIMIT_CPU_LABEL.get());
		label0.setLayout(line_0);

		limitCpuTextFld = factory.createText(c0, "");
		limitCpuTextFld.setToolTipText(LIMIT_CPU_PROP_TIP.get());
		limitCpuTextFld.setLayoutData(createRowData(TEXT_WIDTH));

		// **************************************************************************
		final RowLayout line_1 = createHBox();
		final Composite c1 = factory.createComposite(composite);
		c1.setLayout(line_1);

		final CLabel label1 = factory.createCLabel(c1, RESERVATION_CPU_LABEL.get());
		label1.setLayout(line_1);

		reservationCpuTextFld = factory.createText(c1, "");
		reservationCpuTextFld.setToolTipText(RESERVATION_CPU_PROP_TIP.get());
		reservationCpuTextFld.setLayoutData(createRowData(TEXT_WIDTH));

		// **************************************************************************
		final RowLayout line_2 = createHBox();

		final Composite c2 = factory.createComposite(composite);
		c2.setLayout(line_2);

		final CLabel label2 = factory.createCLabel(c2, LIMIT_MEM_LABEL.get());
		label2.setLayout(line_2);

		limitMemTextFld = factory.createText(c2, "");
		limitMemTextFld.setToolTipText(LIMIT_MEM_PROP_TIP.get());
		limitMemTextFld.setLayoutData(createRowData(TEXT_WIDTH));

		// **************************************************************************
		final RowLayout line_3 = createHBox();
		final Composite c3 = factory.createComposite(composite);
		c3.setLayout(line_3);

		final CLabel label3 = factory.createCLabel(c3, RESERVATION_MEM_LABEL.get());
		label3.setLayout(line_3);

		reservationMemTextFld = factory.createText(c3, "");
		reservationMemTextFld.setToolTipText(RESERVATION_MEM_PROP_TIP.get());
		reservationMemTextFld.setLayoutData(createRowData(TEXT_WIDTH));

		// **************************************************************************
		submitBtn = factory.createButton(composite, TRANSFER.get(), 0);
		submitBtn.setToolTipText(TRANSFER_BTN_TIP.get());
		submitBtn.setLayoutData(createRowData());
	}

	public void setListenerToSubmitBtn(final SelectionListener listener) {
		submitBtn.addSelectionListener(listener);
	}

	public String getLimitCpuInput() {
		return limitCpuTextFld.getText();
	}

	public String getReservationCpuInput() {
		return reservationCpuTextFld.getText();
	}

	public String getLimitMemInput() {
		return limitMemTextFld.getText();
	}

	public String getReservationMemInput() {
		return reservationMemTextFld.getText();
	}

	public void setLimitCpuInput(final String input) {
		if (input != null && !input.isEmpty()) {
			limitCpuTextFld.setText(input);
		}
	}

	public void setReservationCpuInput(final String input) {
		if (input != null && !input.isEmpty()) {
			reservationCpuTextFld.setText(input);
		}
	}

	public void setLimitMemInput(final String input) {
		if (input != null && !input.isEmpty()) {
			limitMemTextFld.setText(input);
		}
	}

	public void setReservationMemInput(final String input) {
		if (input != null && !input.isEmpty()) {
			reservationMemTextFld.setText(input);
		}
	}

}
