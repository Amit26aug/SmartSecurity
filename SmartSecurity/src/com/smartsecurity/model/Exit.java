package com.smartsecurity.model;

public class Exit {
	private String exitTransactionId;
	private String exitRFID;
	private String exitDate;
	private String exitTime;
	
	
	public void setExitTransactionId(String exitTransactionId) {
		this.exitTransactionId = exitTransactionId;
	}
	public void setExitRFID(String exitRFID) {
		this.exitRFID = exitRFID;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	
	
	public String getExitTransactionId() {
		return exitTransactionId;
	}
	public String getExitRFID() {
		return exitRFID;
	}
	public String getExitDate() {
		return exitDate;
	}
	public String getExitTime() {
		return exitTime;
	}

}
