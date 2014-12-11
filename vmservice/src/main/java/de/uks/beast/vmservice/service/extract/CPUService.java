package de.uks.beast.vmservice.service.extract;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarLoader;

public class CPUService extends ExtractorService {

	@Override
	public void extract() {
		try {
			CpuInfo[] infos = sigar.getCpuInfoList();
			CpuPerc[] cpus = sigar.getCpuPercList();
	
			CpuInfo info = infos[0];
			long cacheSize = info.getCacheSize();
			System.out.println("Vendor........." + info.getVendor());
			System.out.println("Model.........." + info.getModel());
			System.out.println("Mhz............" + info.getMhz());
			System.out.println("Total CPUs....." + info.getTotalCores());
			if ((info.getTotalCores() != info.getTotalSockets())
					|| (info.getCoresPerSocket() > info.getTotalCores())) {
				System.out.println("Physical CPUs.." + info.getTotalSockets());
				System.out.println("Cores per CPU.." + info.getCoresPerSocket());
			}
	
			if (cacheSize != Sigar.FIELD_NOTIMPL) {
				System.out.println("Cache size...." + cacheSize);
			}
			System.out.println("");
	
			for (int i = 0; i < cpus.length; i++) {
				System.out.println("CPU " + i + ".........");
				output(cpus[i]);
			}
	
			System.out.println("Totals........");
			output(sigar.getCpuPerc());
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}
	
	private void output(CpuPerc cpu) {
		System.out.println("User Time....." + CpuPerc.format(cpu.getUser()));
		System.out.println("Sys Time......" + CpuPerc.format(cpu.getSys()));
		System.out.println("Idle Time....." + CpuPerc.format(cpu.getIdle()));
		System.out.println("Wait Time....." + CpuPerc.format(cpu.getWait()));
		System.out.println("Nice Time....." + CpuPerc.format(cpu.getNice()));
		System.out.println("Combined......" + CpuPerc.format(cpu.getCombined()));
		System.out.println("Irq Time......" + CpuPerc.format(cpu.getIrq()));
        if (SigarLoader.IS_LINUX) {
        	System.out.println("SoftIrq Time.." + CpuPerc.format(cpu.getSoftIrq()));
        	System.out.println("Stolen Time...." + CpuPerc.format(cpu.getStolen()));
        }
        System.out.println("");
    }

}
