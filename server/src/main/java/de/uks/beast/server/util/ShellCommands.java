package de.uks.beast.server.util;

public class ShellCommands {

	private static final String APPEND_TO_FILE = "sudo bash -c 'echo \"TEXTTOAPPEND\" >> FILENAME'";
	private static final String EXEC_SCRIPT = "sudo sh FILENAME";
	private static final String CREATE_DIR = "mkdir -p DIRNAME";
	private static final String ADD_TO_HOST = "awk '/127.0.0.1/ { print; print \"P_HOST\"; next }1' /etc/hosts > /tmp/hosts && "
			+ "sudo mv /tmp/hosts /etc/hosts";
	private static final String EXEC_BEAST_SERVICE = "nohup java -classpath /tmp/beast/util/bservice.jar:/tmp/beast/util/libs/*" 
			+ " -Djava.library.path=/tmp/beast/util/libs/native" 
			+ " de.uks.beast.vmservice.VMService HOSTNAME KAFKABROKER TOPIC &";

	
	public static String appendToFile(String filePath, String textToAppend) {
		return APPEND_TO_FILE.replace("FILENAME", filePath).replace("TEXTTOAPPEND", textToAppend);
	}
	
	public static String executeScript(String scriptName) {
		return EXEC_SCRIPT.replace("FILENAME", scriptName);
	}
	
	public static String createDirectory(String dirName) {
		return CREATE_DIR.replace("DIRNAME", dirName);
	}
	
	public static String addToHostsFile(String host) {
		return ADD_TO_HOST.replace("P_HOST", host);
	}
	
	public static String executeBeastService(String hostname, String kafkabroker, String topic) {
		return EXEC_BEAST_SERVICE.replace("HOSTNAME", hostname)
								 .replace("KAFKABROKER", kafkabroker)
								 .replace("TOPIC", topic);
	}

	
}
