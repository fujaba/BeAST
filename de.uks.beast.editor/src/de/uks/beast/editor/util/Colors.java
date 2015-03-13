package de.uks.beast.editor.util;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class Colors
{
	//color connection
	public static final IColorConstant	LINE_COLOR_OBJECT_CONNECTION	= new ColorConstant(85, 85, 85);
	
	//color hadoopConnection
	public static final IColorConstant	LINE_COLOR_HADOOP_CONNECTION	= new ColorConstant(0, 190, 0);
	
	//network
	public static final IColorConstant	NETWORK_TEXT_FOREGROUND			= IColorConstant.BLACK;
	public static final IColorConstant	NETWORK_FOREGROUND				= new ColorConstant(98, 131, 167);
	public static final IColorConstant	NETWORK_BACKGROUND				= new ColorConstant(187, 218, 247);
	
	//group
	public static final IColorConstant	GROUP_TEXT_FOREGROUND			= IColorConstant.BLACK;
	public static final IColorConstant	GROUP_FOREGROUND				= new ColorConstant(98, 131, 167);
	public static final IColorConstant	GROUP_BACKGROUND				= new ColorConstant(187, 218, 247);
	
	//router
	public static final IColorConstant	ROUTER_TEXT_FOREGROUND			= IColorConstant.BLACK;
	public static final IColorConstant	ROUTER_FOREGROUND				= new ColorConstant(98, 131, 167);
	public static final IColorConstant	ROUTER_BACKGROUND				= new ColorConstant(187, 218, 247);
	
	//server
	public static final IColorConstant	SERVER_TEXT_FOREGROUND			= IColorConstant.BLACK;
	public static final IColorConstant	SERVER_FOREGROUND				= new ColorConstant(98, 131, 167);
	public static final IColorConstant	SERVER_BACKGROUND				= new ColorConstant(187, 218, 247);
}
