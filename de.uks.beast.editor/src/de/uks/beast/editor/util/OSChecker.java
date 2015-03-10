package de.uks.beast.editor.util;

import java.util.Locale;

public final class OSChecker
{
	
	protected enum OSType
	{
		Windows, MacOS, Linux, Other
	};
	
	private static OSType	detectedOS;
	
	
	
	/**
	 * @returns - the operating system detected
	 */
	protected static OSType getOperatingSystemType()
	{
		if (detectedOS == null)
		{
			final String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
			if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0))
			{
				detectedOS = OSType.MacOS;
			}
			else if (OS.indexOf("win") >= 0)
			{
				detectedOS = OSType.Windows;
			}
			else if (OS.indexOf("nux") >= 0)
			{
				detectedOS = OSType.Linux;
			}
			else
			{
				detectedOS = OSType.Other;
			}
		}
		return detectedOS;
	}
}
