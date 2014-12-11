package de.uks.beast.vmservice.service.extract;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.SigarException;

import de.uks.beast.vmservice.service.model.StringLongPair;

public class MemoryService extends ExtractorService {

	@Override
	public void extract() {
		this.keys.clear();
		
		try {
			Mem mem = sigar.getMem();
			keys.add(new StringLongPair("Total", mem.getTotal()));
			keys.add(new StringLongPair("Ram", mem.getRam()));
			keys.add(new StringLongPair("Free", mem.getActualFree()));
			keys.add(new StringLongPair("Used", mem.getActualUsed()));
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}

}
