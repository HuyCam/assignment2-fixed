package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount {
	private long accNumber;
	private CDOffering offering;
	private double balance;
	private Date date;
	
	
	CDAccount(CDOffering offering, double openingBalance) {
		this.offering = offering;
		this.balance = openingBalance;
		this.date = new Date();
		accNumber = MeritBank.getNextAccountNumber();
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return offering.getInterestRate();

	}
	
	public int getTerm() {
		return offering.getTerm();
	}
	
	public Date getStartDate() {
		return date;
	}
	
	public long getAccountNumber() {
		// not sure, assumming that the future value is 3 years
		
		return accNumber;
	}
	
	public double futreValue() {
		double futureVal = this.balance * Math.pow(1 + offering.getInterestRate(), 3);
		return futureVal;
	}
}
