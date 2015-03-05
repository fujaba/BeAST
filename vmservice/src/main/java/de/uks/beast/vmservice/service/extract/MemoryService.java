package de.uks.beast.vmservice.service.extract;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.SigarException;

import de.uks.beast.vmservice.service.model.InstanceInformation;

public class MemoryService extends ExtractorService {

	public MemoryService(String host) {
		super(host);
	}

	@Override
	public void extract() {
		this.keys.clear();
		
		try {
			Mem mem = sigar.getMem();
			/*keys.add(new InstanceInformation(host, "mem-total", "" + mem.getTotal()));
			keys.add(new InstanceInformation(host, "mem-ram", "" + mem.getRam()));
			keys.add(new InstanceInformation(host, "mem-free", "" + mem.getActualFree()));*/
			keys.add(new InstanceInformation(host, "mem-used", "" + ((double) mem.getActualUsed()/mem.getTotal())));
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}

}
