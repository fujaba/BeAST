package de.uks.beast.editor.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.algorithms.styles.AdaptedGradientColoredAreas;
import org.eclipse.graphiti.mm.algorithms.styles.GradientColoredArea;
import org.eclipse.graphiti.mm.algorithms.styles.GradientColoredAreas;
import org.eclipse.graphiti.mm.algorithms.styles.LocationType;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.util.IGradientType;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;
import org.eclipse.graphiti.util.PredefinedColoredAreas;

public class MyColoredAreas extends PredefinedColoredAreas implements MyRenderingStyle
{
	
	private static GradientColoredAreas getLimeWhiteDefaultAreas()
	{
		final GradientColoredAreas gradientColoredAreas = StylesFactory.eINSTANCE.createGradientColoredAreas();
		final EList<GradientColoredArea> gcas = gradientColoredAreas.getGradientColor();
		
		addGradientColoredArea(gcas, "CCFFCC", 0, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CCFFCC", 1,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CCFF99", 1, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CCFF99", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CCFF66", 2, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CCFF66", 3,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "66FF00", 3, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CCFFCC", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		addGradientColoredArea(gcas, "CCFFCC", 2, LocationType.LOCATION_TYPE_ABSOLUTE_END, "CCFFCC", 0,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		gradientColoredAreas.setStyleAdaption(IPredefinedRenderingStyle.STYLE_ADAPTATION_DEFAULT);
		return gradientColoredAreas;
	}
	
	
	
	private static GradientColoredAreas getLimeWhitePrimarySelectedAreas()
	{
		final GradientColoredAreas gradientColoredAreas = StylesFactory.eINSTANCE.createGradientColoredAreas();
		gradientColoredAreas.setStyleAdaption(IPredefinedRenderingStyle.STYLE_ADAPTATION_PRIMARY_SELECTED);
		final EList<GradientColoredArea> gcas = gradientColoredAreas.getGradientColor();
		
		addGradientColoredArea(gcas, "66CCCC", 0, LocationType.LOCATION_TYPE_ABSOLUTE_START, "66CCCC", 1,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "66CC99", 1, LocationType.LOCATION_TYPE_ABSOLUTE_START, "66CC99", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "66CC66", 2, LocationType.LOCATION_TYPE_ABSOLUTE_START, "66CC66", 3,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "00CC00", 3, LocationType.LOCATION_TYPE_ABSOLUTE_START, "00CC66", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		addGradientColoredArea(gcas, "00CC99", 2, LocationType.LOCATION_TYPE_ABSOLUTE_END, "00CC99", 0,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		return gradientColoredAreas;
	}
	
	
	
	private static GradientColoredAreas getLimeWhiteSecondarySelectedAreas()
	{
		final GradientColoredAreas gradientColoredAreas = StylesFactory.eINSTANCE.createGradientColoredAreas();
		gradientColoredAreas.setStyleAdaption(IPredefinedRenderingStyle.STYLE_ADAPTATION_SECONDARY_SELECTED);
		final EList<GradientColoredArea> gcas = gradientColoredAreas.getGradientColor();
		
		addGradientColoredArea(gcas, "33CCCC", 0, LocationType.LOCATION_TYPE_ABSOLUTE_START, "33CCCC", 1,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "33CC99", 1, LocationType.LOCATION_TYPE_ABSOLUTE_START, "33CC99", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "33CC66", 2, LocationType.LOCATION_TYPE_ABSOLUTE_START, "33CC66", 3,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "33CC00", 3, LocationType.LOCATION_TYPE_ABSOLUTE_START, "33CC99", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		addGradientColoredArea(gcas, "66CC99", 2, LocationType.LOCATION_TYPE_ABSOLUTE_END, "66CC99", 0,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		return gradientColoredAreas;
	}
	
	
	
	protected static AdaptedGradientColoredAreas getLimeWhiteAdaptions()
	{
		final AdaptedGradientColoredAreas agca = StylesFactory.eINSTANCE.createAdaptedGradientColoredAreas();
		agca.setDefinedStyleId(LIME_WHITE_ID);
		agca.setGradientType(IGradientType.VERTICAL);
		agca.getAdaptedGradientColoredAreas().add(IPredefinedRenderingStyle.STYLE_ADAPTATION_DEFAULT, getLimeWhiteDefaultAreas());
		agca.getAdaptedGradientColoredAreas().add(IPredefinedRenderingStyle.STYLE_ADAPTATION_PRIMARY_SELECTED,
				getLimeWhitePrimarySelectedAreas());
		agca.getAdaptedGradientColoredAreas().add(IPredefinedRenderingStyle.STYLE_ADAPTATION_SECONDARY_SELECTED,
				getLimeWhiteSecondarySelectedAreas());
		return agca;
	}
	
	
	
	protected static AdaptedGradientColoredAreas getRedWhiteAdaptions()
	{
		final AdaptedGradientColoredAreas agca = StylesFactory.eINSTANCE.createAdaptedGradientColoredAreas();
		agca.setDefinedStyleId(RED_WHITE_ID);
		agca.setGradientType(IGradientType.VERTICAL);
		agca.getAdaptedGradientColoredAreas().add(IPredefinedRenderingStyle.STYLE_ADAPTATION_DEFAULT, getRedWhiteDefaultAreas());
		agca.getAdaptedGradientColoredAreas().add(IPredefinedRenderingStyle.STYLE_ADAPTATION_PRIMARY_SELECTED,
				getRedWhitePrimarySelectedAreas());
		agca.getAdaptedGradientColoredAreas().add(IPredefinedRenderingStyle.STYLE_ADAPTATION_SECONDARY_SELECTED,
				getRedWhiteSecondarySelectedAreas());
		return agca;
	}
	
	
	
	private static GradientColoredAreas getRedWhiteSecondarySelectedAreas()
	{
		final GradientColoredAreas gradientColoredAreas = StylesFactory.eINSTANCE.createGradientColoredAreas();
		gradientColoredAreas.setStyleAdaption(IPredefinedRenderingStyle.STYLE_ADAPTATION_SECONDARY_SELECTED);
		final EList<GradientColoredArea> gcas = gradientColoredAreas.getGradientColor();
		
		addGradientColoredArea(gcas, "CD3333", 0, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD3333", 1,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CD3333", 1, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD3333", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CD3333", 2, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD3333", 3,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CD0000", 3, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD3333", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		addGradientColoredArea(gcas, "CD6666", 2, LocationType.LOCATION_TYPE_ABSOLUTE_END, "CD6666", 0,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		return gradientColoredAreas;
	}
	
	
	
	private static GradientColoredAreas getRedWhitePrimarySelectedAreas()
	{
		final GradientColoredAreas gradientColoredAreas = StylesFactory.eINSTANCE.createGradientColoredAreas();
		gradientColoredAreas.setStyleAdaption(IPredefinedRenderingStyle.STYLE_ADAPTATION_PRIMARY_SELECTED);
		final EList<GradientColoredArea> gcas = gradientColoredAreas.getGradientColor();
		
		addGradientColoredArea(gcas, "CD6666", 0, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD6666", 1,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CD6666", 1, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD6666", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CD6666", 2, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD6666", 3,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "CD0000", 3, LocationType.LOCATION_TYPE_ABSOLUTE_START, "CD0000", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		addGradientColoredArea(gcas, "CD0000", 2, LocationType.LOCATION_TYPE_ABSOLUTE_END, "CD0000", 0,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		return gradientColoredAreas;
	}
	
	
	
	private static GradientColoredAreas getRedWhiteDefaultAreas()
	{
		final GradientColoredAreas gradientColoredAreas = StylesFactory.eINSTANCE.createGradientColoredAreas();
		final EList<GradientColoredArea> gcas = gradientColoredAreas.getGradientColor();
		
		addGradientColoredArea(gcas, "FFCDCD", 0, LocationType.LOCATION_TYPE_ABSOLUTE_START, "FFCDCD", 1,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "FF9A9A", 1, LocationType.LOCATION_TYPE_ABSOLUTE_START, "FF9A9A", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "FF6666", 2, LocationType.LOCATION_TYPE_ABSOLUTE_START, "FF6666", 3,
				LocationType.LOCATION_TYPE_ABSOLUTE_START);
		addGradientColoredArea(gcas, "FF0000", 3, LocationType.LOCATION_TYPE_ABSOLUTE_START, "FFCDCD", 2,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		addGradientColoredArea(gcas, "FFCDCD", 2, LocationType.LOCATION_TYPE_ABSOLUTE_END, "FFCDCD", 0,
				LocationType.LOCATION_TYPE_ABSOLUTE_END);
		gradientColoredAreas.setStyleAdaption(IPredefinedRenderingStyle.STYLE_ADAPTATION_DEFAULT);
		return gradientColoredAreas;
	}
}
