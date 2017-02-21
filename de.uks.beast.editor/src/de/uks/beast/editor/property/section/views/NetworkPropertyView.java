package de.uks.beast.editor.property.section.views;

import static de.uks.beast.editor.util.Properties.ATTR_0_LABEL;
import static de.uks.beast.editor.util.Properties.ATTR_1_LABEL;
import static de.uks.beast.editor.util.Properties.TRANSFER;

import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uks.beast.editor.util.ToolTips;

public class NetworkPropertyView {
	private Text attr_0TextFld;
	private Text attr_1TextFld;
	private Button submitBtn;

	private static final int TEXT_WIDTH = 100;

	public NetworkPropertyView(final Composite parent, final TabbedPropertySheetWidgetFactory factory) {
		createContent(parent, factory);
	}

	private void createContent(final Composite composite, final TabbedPropertySheetWidgetFactory factory) {

		final RowLayout vBox = createVBox();
		composite.setLayout(vBox);

		// **************************************************************************
		final RowLayout line_1 = createHBox();
		
		final Composite c = factory.createComposite(composite);
		c.setLayout(line_1);

		final CLabel label = factory.createCLabel(c, ATTR_0_LABEL.get());
		label.setLayout(line_1);

		attr_0TextFld = factory.createText(c, "");
		attr_0TextFld.setToolTipText(ToolTips.ATTR_0_PROP_TIP.get());
		attr_0TextFld.setLayoutData(new RowData(TEXT_WIDTH, SWT.DEFAULT));

		// **************************************************************************
		final RowLayout line_2 = createHBox();
		final Composite c1 = factory.createComposite(composite);
		c1.setLayout(line_2);

		final CLabel valueLabe2 = factory.createCLabel(c1, ATTR_1_LABEL.get());
		valueLabe2.setLayout(line_2);

		attr_1TextFld = factory.createText(c1, "");
		attr_1TextFld.setToolTipText(ToolTips.ATTR_1_PROP_TIP.get());
		attr_1TextFld.setLayoutData(new RowData(TEXT_WIDTH, SWT.DEFAULT));

		// **************************************************************************
		submitBtn = factory.createButton(composite, TRANSFER.get(), 0);
		submitBtn.setToolTipText(ToolTips.TRANSFER_BTN_TIP.get());
		submitBtn.setLayoutData(new RowData());
	}

	private RowLayout createHBox() {
		final RowLayout hbox = new RowLayout(SWT.HORIZONTAL);
		hbox.fill = true;

		return hbox;
	}

	private RowLayout createVBox() {
		final RowLayout vbox = new RowLayout(SWT.VERTICAL);
		return vbox;
	}

	public void setListenerToSubmitBtn(final SelectionListener listener) {
		submitBtn.addSelectionListener(listener);
	}

	public String getAttr_0Input() {
		return attr_0TextFld.getText();
	}

	public String getAttr_1Input() throws UnknownHostException {
		return attr_1TextFld.getText();
	}

	public void setAttr_0Input(final String input) {
		if (input != null && !input.isEmpty()) {
			attr_0TextFld.setText(input);
		}
	}

	public void setAttr_1Input(final String input) {
		if (input != null && !input.isEmpty()) {
			attr_1TextFld.setText(input);
		}
	}

}
