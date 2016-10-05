package org.dhanesh.javabrains.main;

public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String reason;
	private String detail;

	public InvalidInputException(String message, String details) {
		super(message);
		this.reason = message;
		this.detail = details;
	}

	public String getFaultInfo() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFaultDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	
	
}
