package com.smartsecurity.model;

public class Visit {
	private String visitTransactionId;
	private String visitVisitorId;
	private String visitRFID;
	private String visitDepartmentId;
	private String visitPurpose;
	private String visitDate;
	private String visitCheckinTime;
	private String visitCheckoutTime;
	private String visitStatus;
	private String visitHost;
	
	public String getVisitHost() {
		return visitHost;
	}
	public void setVisitHost(String visitHost) {
		this.visitHost = visitHost;
	}
	public String getVisitTransactionId() {
		return visitTransactionId;
	}
	public void setVisitTransactionId(String visitTransactionId) {
		this.visitTransactionId = visitTransactionId;
	}
	public String getVisitVisitorId() {
		return visitVisitorId;
	}
	public void setVisitVisitorId(String visitVisitorId) {
		this.visitVisitorId = visitVisitorId;
	}
	public String getVisitRFID() {
		return visitRFID;
	}
	public void setVisitRFID(String visitRFID) {
		this.visitRFID = visitRFID;
	}
	public String getVisitDepartmentId() {
		return visitDepartmentId;
	}
	public void setVisitDepartmentId(String visitDepartmentId) {
		this.visitDepartmentId = visitDepartmentId;
	}
	public String getVisitPurpose() {
		return visitPurpose;
	}
	public void setVisitPurpose(String visitPurpose) {
		this.visitPurpose = visitPurpose;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitCheckinTime() {
		return visitCheckinTime;
	}
	public void setVisitCheckinTime(String visitCheckinTime) {
		this.visitCheckinTime = visitCheckinTime;
	}
	public String getVisitCheckoutTime() {
		return visitCheckoutTime;
	}
	public void setVisitCheckoutTime(String visitCheckoutTime) {
		this.visitCheckoutTime = visitCheckoutTime;
	}
	public String getVisitStatus() {
		return visitStatus;
	}
	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}
	
}