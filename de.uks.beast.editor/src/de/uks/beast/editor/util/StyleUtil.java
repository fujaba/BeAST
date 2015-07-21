package de.uks.beast.editor.util;

import org.eclipse.graphiti.mm.algorithms.styles.AdaptedGradientColoredAreas;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.util.PredefinedColoredAreas;

public class StyleUtil
{
	public static final String			GROUP_STYLE_ID			= "groupStyle";
	public static final String			SERVER_STYLE_ID			= "serverStyle";
	public static final String			ROUTER_STYLE_ID			= "routerStyle";
	public static final String			NETWORK_STYLE_ID		= "networkStyle";
	private static final IColorConstant	E_CLASS_TEXT_FOREGROUND	= new ColorConstant(0, 0, 0);
	private static final IColorConstant	E_CLASS_FOREGROUND		= new ColorConstant(98, 131, 167);
	
	
	
	public static Style getStyleForCommonValues(Diagram diagram)
	{
		final String styleId = "COMMON-VALUES";
		IGaService gaService = Graphiti.getGaService();
		
		// Is style already persisted?
		Style style = gaService.findStyle(diagram, styleId);
		
		if (style == null)
		{ // style not found - create new style
			style = gaService.createPlainStyle(diagram, styleId);
			setCommonValues(style);
		}
		return style;
	}
	
	
	
	public static Style getBlueWhiteGlossStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, PredefinedColoredAreas.getBlueWhiteGlossAdaptions());
	}
	
	
	
	public static Style getBlueWhiteStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, PredefinedColoredAreas.getBlueWhiteAdaptions());
	}
	
	
	
	public static Style getCopperWhiteGlossStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, PredefinedColoredAreas.getCopperWhiteGlossAdaptions());
	}
	
	
	
	public static Style getLightGrayStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, PredefinedColoredAreas.getLightGrayAdaptions());
	}
	
	
	
	public static Style getLightYellowStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, PredefinedColoredAreas.getLightYellowAdaptions());
	}
	
	
	
	public static Style getSilverWhiteGlossStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, PredefinedColoredAreas.getSilverWhiteGlossAdaptions());
	}
	
	
	
	public static Style getLimeWhiteStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, MyColoredAreas.getLimeWhiteAdaptions());
	}
	
	
	
	public static Style getRedWhiteStyleForObject(final Diagram diagram, final String styleId)
	{
		return getSpecificStyle(diagram, styleId, MyColoredAreas.getRedWhiteAdaptions());
	}
	
	
	
	private static Style getSpecificStyle(final Diagram diagram, final String styleId,
			final AdaptedGradientColoredAreas coloredArea)
	{
		final IGaService gaService = Graphiti.getGaService();
		
		// this is a child style of the common-values-style
		final Style parentStyle = getStyleForCommonValues(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);
		
		if (style == null)
		{ // style not found - create new style
			style = gaService.createPlainStyle(parentStyle, styleId);
			style.setFilled(true);
			style.setForeground(gaService.manageColor(diagram, E_CLASS_FOREGROUND));
			
			gaService.setRenderingStyle(style, coloredArea);
		}
		return style;
	}
	
	
	
	public static Style getStyleForEClassText(Diagram diagram)
	{
		final String styleId = "E-CLASS-TEXT";
		IGaService gaService = Graphiti.getGaService();
		
		// this is a child style of the common-values-style
		Style parentStyle = getStyleForCommonValues(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);
		
		if (style == null)
		{ // style not found - create new style
			style = gaService.createPlainStyle(parentStyle, styleId);
			setCommonTextValues(diagram, gaService, style);
			style.setFont(gaService.manageDefaultFont(diagram, false, true));
		}
		return style;
	}
	
	
	
	public static Style getStyleForTextDecorator(Diagram diagram)
	{
		final String styleId = "TEXT-DECORATOR-TEXT";
		IGaService gaService = Graphiti.getGaService();
		
		// this is a child style of the common-values-style
		Style parentStyle = getStyleForCommonValues(diagram);
		Style style = gaService.findStyle(parentStyle, styleId);
		
		if (style == null)
		{ // style not found - create new style
			style = gaService.createPlainStyle(parentStyle, styleId);
			setCommonTextValues(diagram, gaService, style);
			style.setFont(gaService.manageDefaultFont(diagram, true, false));
		}
		return style;
	}
	
	
	
	private static void setCommonTextValues(Diagram diagram, IGaService gaService, Style style)
	{
		style.setFilled(false);
		style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		style.setForeground(gaService.manageColor(diagram, E_CLASS_TEXT_FOREGROUND));
	}
	
	
	
	private static void setCommonValues(Style style)
	{
		style.setLineStyle(LineStyle.SOLID);
		style.setLineVisible(true);
		style.setLineWidth(2);
		style.setTransparency(0.0);
	}
}
