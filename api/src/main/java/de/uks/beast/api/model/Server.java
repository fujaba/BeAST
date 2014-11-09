package de.uks.beast.api.model;

public class Server
{
	
	private String	host;
	private int		cpu;
	private long	ram;
	private int		diskSpace;
	
	
	
	public String getHost()
	{
		return host;
	}
	
	
	
	public int getCpu()
	{
		return cpu;
	}
	
	
	
	public long getRam()
	{
		return ram;
	}
	
	
	
	public int getDiskSpace()
	{
		return diskSpace;
	}
	
	
	
	public void setHost(final String host)
	{
		this.host = host;
	}
	
	
	
	public void setCpu(final int cpu)
	{
		this.cpu = cpu;
	}
	
	
	
	public void setRam(final long ram)
	{
		this.ram = ram;
	}
	
	
	
	public void setDiskSpace(final int diskSpace)
	{
		this.diskSpace = diskSpace;
	}
}
