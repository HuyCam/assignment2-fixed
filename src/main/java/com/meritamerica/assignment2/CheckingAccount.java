package com.meritamerica.assignment2;

public class CheckingAccount {
	private long accNumber;
	private double balance;
	private static final double INTEREST_RATE = 0.0001;
	
	public CheckingAccount(double balance) {
		this.accNumber = MeritBank.getNextAccountNumber();
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double amount) {
		if (amount > this.balance) {
			System.out.println("Insufficient amount in the checking account to withdraw");
			return false;
		} else {
			this.balance -= amount;
			System.out.println("Transaction Complete.");
			return true;
		}
	}
	
	public static double getInterestRate() {
		return INTEREST_RATE;
	}
	
	public boolean deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Please deposit sufficient amount");
			return false;
		} else {
			this.balance += amount;
			System.out.println("Transaction Complete.");
			return true;
		}
	}

	public double futureValue(int years) {
		// Calculate future value base on the formula: FV = PV(1 + i)^n
		double futureVal = this.balance * Math.pow(1 + getInterestRate(), years);
		
		return futureVal;
	}
	
	// Printing out the information of this checking account
	// String.format is the class method to format the number output
	@Override
	public String toString() {
		String output = "1. Checking account balance: $" + this.balance + "\n"
					+	"2. Checking account interest rate: " + String.format("%.4f", getInterestRate()) + "\n"
					+	"3. Checking account balance in 3 years: $" + String.format("%.2f", futureValue(3));
		return output;
	}
	
	public long getAccountNumber() {
		return this.accNumber;
	}
	
}