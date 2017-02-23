package de.uks.beast.editor.property.section.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;

public class NodeFactory {

	private NodeFactory() {
		// TODO Auto-generated constructor stub
	}

	protected static RowLayout createHBox() {
		final RowLayout hbox = new RowLayout(SWT.HORIZONTAL);
		hbox.fill = true;

		return hbox;
	}

	protected static RowLayout createVBox() {
		final RowLayout vbox = new RowLayout(SWT.VERTICAL);
		return vbox;
	}

	protected static RowData createRowData(final int width) {
		return new RowData(width, SWT.DEFAULT);
	}

	protected static RowData createRowData() {
		return createRowData(SWT.DEFAULT);
	}

}
