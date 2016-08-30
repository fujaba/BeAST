package de.uks.beast.api.akka;

import java.util.HashMap;
import java.util.Map;

public class BeastConnection {

	private String info;
	private Map<String, Info> conInfos;
	
	public BeastConnection() {
		this.conInfos = new HashMap<String, Info>();
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void addConnectionInfo(String host, String ip, String key) {
		this.conInfos.put(host, new Info(ip, key));
	}
	
	public Map<String, Info> getConInfos() {
		return conInfos;
	}
	
	public static class Info {
		
		private String ip;
		private String key;
		
		public Info(String ip, String key) {
			this.ip = ip;
			this.key = key;
		}

		public String getIp() {
			return ip;
		}
		
		public void setIp(String ip) {
			this.ip = ip;
		}
		
		public String getKey() {
			return key;
		}
		
		public void setKey(String key) {
			this.key = key;
		}
		
	}
}
