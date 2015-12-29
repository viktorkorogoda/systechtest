package com.viktor.systechtest.entity;

public class Tasks {
	private int id;
	private String summary;
	private String startDate;
	private String endDate;
	private String assignee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startdate) {
		this.startDate = startdate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String enddate) {
		this.endDate = enddate;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	
}
