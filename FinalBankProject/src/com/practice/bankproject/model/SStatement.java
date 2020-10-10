package com.practice.bankproject.model;

public class SStatement {
	private String DateOfTransfer;
	private String sendersaccount_id;
	private String receiversaccount_id;
	private Double amount;
	public String getDateOfTransfer() {
		return DateOfTransfer;
	}
	public void setDateOfTransfer(String dateOfTransfer) {
		this.DateOfTransfer = dateOfTransfer;
	}
	public String getSendersaccount_id() {
		return sendersaccount_id;
	}
	public void setSendersaccount_id(String sendersaccount_id) {
		this.sendersaccount_id = sendersaccount_id;
	}
	public String getReceiversaccount_id() {
		return receiversaccount_id;
	}
	public void setReceiversaccount_id(String receiversaccount_id) {
		this.receiversaccount_id = receiversaccount_id;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "SStatement [dateOfTransfer=" + DateOfTransfer + ", sendersaccount_id=" + sendersaccount_id
				+ ", receiversaccount_id=" + receiversaccount_id + ", amount=" + amount + "]";
	}
	
}
