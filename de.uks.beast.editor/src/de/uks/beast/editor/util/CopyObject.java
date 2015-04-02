package de.uks.beast.editor.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class CopyObject
{
	private final PictogramElement	pictogramElement;
	private final Object			businessObject;
	
	
	
	private CopyObject(final PictogramElement pictogramElement, final Object businessObject)
	{
		this.pictogramElement = pictogramElement;
		this.businessObject = businessObject;
	}
	
	
	
	public static CopyObject create(final PictogramElement pictogramElement, final Object businessObject)
	{
		return new CopyObject(pictogramElement, businessObject);
	}
	
	
	
	/**
	 * @return the pictogramElement
	 */
	public final PictogramElement getPictogramElement()
	{
		return pictogramElement;
	}
	
	
	
	/**
	 * @return the businessObject
	 */
	public final Object getBusinessObject()
	{
		return businessObject;
	}
	
}
