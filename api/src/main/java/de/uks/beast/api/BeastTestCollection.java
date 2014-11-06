package de.uks.beast.api;

import java.util.ArrayList;

public class BeastTestCollection {

	private ArrayList<String> hadoopTests;
	
	public BeastTestCollection() {
		this.hadoopTests = new ArrayList<String>();
	}
	
	/**
	 * Adds a Hadoop job file to the collection of tests which
	 * will be executed on the testing system.
	 * 
	 * @param path Absolute path to Hadoop job file
	 */
	public void addHadoopTest(String path) {
		this.hadoopTests.add(path);
	}
	
	@Override
	public String toString() {
		String s = "[";
		
		for (int i = 0; i < hadoopTests.size(); i++) {
			s += hadoopTests.get(i);
			if (i != (hadoopTests.size() -1)) {
				s += ", ";
			}
		}
		
		s += "]";
		return s;
	}
	
}
