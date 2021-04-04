package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_current2")
public class Current extends Account {
	double recurringDeposit;
	
	public Current() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Current(String accountPassword, double balance,double recurringDeposit) {
		super(accountPassword, balance);
		// TODO Auto-generated constructor stub
		this.recurringDeposit=recurringDeposit;
	}
	public double getRecurringDeposit() {
		return recurringDeposit;
	}
	public void setRecurringDeposit(double recurringDeposit) {
		this.recurringDeposit = recurringDeposit;
	}
	
}
