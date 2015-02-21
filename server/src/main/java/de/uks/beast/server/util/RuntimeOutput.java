package de.uks.beast.server.util;

public class RuntimeOutput {

	private int status;
	private String message;

	public RuntimeOutput(int statusCode, String message) {
		super();
		this.status = statusCode;
		this.message = message;
	}

	//
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
