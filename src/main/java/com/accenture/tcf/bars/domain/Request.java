package com.accenture.tcf.bars.domain;

import java.util.Date;

public class Request {
	private int billingCycle;
	private Date startDate;
	private Date  endDate;

	public Request(int billingCycle, Date startDate, Date endDate) {
		this.billingCycle = billingCycle;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Request() {
		// TODO Auto-generated constructor stub
	}
	public int getBillingCycle() {
		return billingCycle;
	}
	public void setBillingCycle(int billingCycle) {
		this.billingCycle = billingCycle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Request [billingCycle=" + billingCycle + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
