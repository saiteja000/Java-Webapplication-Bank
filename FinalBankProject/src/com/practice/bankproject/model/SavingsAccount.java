package com.practice.bankproject.model;

public class SavingsAccount {

	private String saccount_id;
	private String scostumer_id;
	private double balance;
	public String getSaccount_id() {
		return saccount_id;
	}
	public void setSaccount_id(String saccount_id) {
		this.saccount_id = saccount_id;
	}
	public String getScostumer_id() {
		return scostumer_id;
	}
	public void setScostumer_id(String scostumer_id) {
		this.scostumer_id = scostumer_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "SavingsAccount [saccount_id=" + saccount_id + ", scostumer_id=" + scostumer_id + ", balance="
				+ balance + "]";
	}
}
