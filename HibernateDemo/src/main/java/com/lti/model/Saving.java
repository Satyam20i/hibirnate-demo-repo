package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_saving2")
public class Saving extends Account {
	double interestRate;
	double minimumBalance;
	public Saving() {
		super();
		
	}
	
	public Saving(String accountPassword, double balance, double interestRate,double minimumBalance) {
		super(accountPassword, balance);
		// TODO Auto-generated constructor stub
		this.interestRate=interestRate;
		this.minimumBalance=minimumBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
}
