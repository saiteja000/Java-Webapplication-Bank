package com.practice.bankproject.model;



public class FixedDeposit {
	private String faccount_id;
	private String fcustomer_id;
	private String startDate;
	private String endDate;
	private double roi;
	private double amount;
	private double maturityamount;
	
	public String getFaccount_id() {
		return faccount_id;
	}

	public void setFaccount_id(String faccount_id) {
		this.faccount_id = faccount_id;
	}

	public String getFcustomer_id() {
		return fcustomer_id;
	}

	public void setFcustomer_id(String fcustomer_id) {
		this.fcustomer_id = fcustomer_id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getMaturityamount() {
		return maturityamount;
	}

	public void setMaturityamount(double maturityamount) {
		this.maturityamount = maturityamount;
	}

	@Override
	public String toString() {
		return "FixedDeposit [faccount_id=" + faccount_id + ", fcustomer_id=" + fcustomer_id + ", startDate="
				+ startDate + ", endDate=" + endDate + ", roi=" + roi + ", amount=" + amount + "]";
	}
}
