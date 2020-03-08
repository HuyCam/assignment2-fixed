package com.meritamerica.assignment2;

import java.util.Arrays;

public class AccountHolder {
	 	private String firstName;
	    private String middleName;
	    private String lastName;
	    private String ssn;
	    private CheckingAccount[] checkingAccounts;
	    private SavingsAccount[] savingsAccounts;
	    private CDAccount[] CDAccounts;
	    
	    // keep track of numbers of checkings and saving accounts
	    private int numberOfCheckings = 0;
	    private int numberOfSavings = 0;
	    private int numberOfCDAs = 0;

	    AccountHolder (){}
	    AccountHolder(String firstName, String middleName, String lastName, String ssn){
	        this.firstName = firstName;
	        this.middleName = middleName;
	        this.lastName = lastName;
	        this.ssn = ssn;
	        
	        // instantiate array of Checkings
	        checkingAccounts = new CheckingAccount[10];
	        savingsAccounts = new SavingsAccount[10];
	        CDAccounts = new CDAccount[10];
	    }
	    
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    public String getMiddleName() {
	        return middleName;
	    }
	    public void setMiddleName(String middleName) {
	        this.middleName = middleName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastname(String lastName) {
	        this.lastName = lastName;
	    }
	    public String getSSN() {
	        return ssn;
	    }
	    public void setSSN(String ssn) {
	        this.ssn = ssn;
	    }

//	    @Override
//	    public String toString() {
//	        return "First Name:" + this.firstName + "\n"  + "Middle Name:" + this.middleName +  "\n"  + "Last Name:" + this.lastName
//	                +  "\n" + "SSN:" + this.ssn +  "\n"  +"Checking Account Balance:" + this.checkingAccount.getBalance() +
//	                "\n" + "Savings Account Balance:" + this.savingsAccount.getBalance();
//	    }
	    
	    public CheckingAccount addCheckingAccount(double openingBalance) {
	    	if (canOpen(openingBalance)) {
		    	// increment number of checkings
		    	this.numberOfCheckings++;
		    	
		    	
		    	this.checkingAccounts[this.numberOfCheckings - 1] = new CheckingAccount(openingBalance);
		    	
		    	return checkingAccounts[this.numberOfCheckings - 1];
	    	}
	    	
	    	return null;

	    }
	    
	    public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
	    	// check the opening account condition
	    	if (canOpen(checkingAccount.getBalance())) {
		    	// increment numberOfCheckings currently have
		    	this.numberOfCheckings++;
		    	
		    	this.checkingAccounts[this.numberOfCheckings - 1] = checkingAccount;
		    	
		    	return this.checkingAccounts[this.numberOfCheckings - 1];
	    	}
	    	
	    	return null;
	    	

	    }
	    
	    public CheckingAccount[] getCheckingAccounts( ) {
	    	return this.checkingAccounts;
	    }
	    
	    public int getNumberOfCheckingAccounts() {
	    	return this.numberOfCheckings;
	    }
	    
	    public double getCheckingBalance() {
	    	double total = 0;
	    	for (int i=0; i < this.numberOfCheckings ; i++ ) {
	    		total += this.checkingAccounts[i].getBalance();
	    	}
	    	
	    	return total;
	    }
	    
	    public SavingsAccount addSavingsAccount(double openingBalance) {
	    	
	    	if (canOpen(openingBalance)) {
	    		// increment numberOfSavings current have
		    	this.numberOfSavings++;
		    	
		    	this.savingsAccounts[this.numberOfSavings - 1] = new SavingsAccount(openingBalance);
		    	
		    	return this.savingsAccounts[this.numberOfSavings - 1];
	    	}
	    	return null;
	    	
	    }
	    
	    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
	    	// check if total ammount is greater than 250, 000
	    	if (canOpen(savingsAccount.getBalance())) {
	    		this.numberOfSavings++;
		    	
		    	this.savingsAccounts[this.numberOfSavings - 1] = savingsAccount;
		    	
		    	return this.savingsAccounts[this.numberOfSavings - 1];
	    	}
	    	
	    	return null;
	    	
	    }
	    
	    public SavingsAccount[] getSavingsAccounts() {
	    	return this.savingsAccounts;
	    }
	    
	    public int getNumberOfSavingsAccounts() {
	    	return this.numberOfSavings;
	    }
	    
	    public double getSavingsBalance() {
	    	double total = 0;
	    	for (int i=0; i < this.numberOfSavings; i++ ) {
	    		total += this.savingsAccounts[i].getBalance();
	    	}
	    	
	    	return total;
	    }
	    
	    public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
	    	this.numberOfCDAs++;
	    	
	    	this.CDAccounts[this.numberOfCDAs - 1] = new CDAccount(offering, openingBalance);
	    	
	    	return this.CDAccounts[this.numberOfCDAs - 1];
	    	
	    }
	    
	    public CDAccount addCDAccount(CDAccount cdAccount) {
	    	this.numberOfCDAs++;
	    	
	    	this.CDAccounts[this.numberOfCDAs - 1] = cdAccount;
	    	
	    	return this.CDAccounts[this.numberOfCDAs - 1];
	    }
	    
	    public CDAccount[] getCDAccounts() {
	    	return this.CDAccounts;
	    }
	    
	    public int getNumberOfCDAccounts() {
	    	return this.numberOfCDAs;
	    }
	    
	    public double getCDBalance() {
	    	double total = 0;
	    	for (int i=0; i < this.numberOfCDAs; i++ ) {
	    		total += this.CDAccounts[i].getBalance();
	    	}
	    	
	    	return total;
	    }
	    
	    public double getCombinedBalance() {
	    	return this.getCDBalance() + this.getCheckingBalance() + this.getSavingsBalance();
	    }
	    
	    private boolean canOpen(double deposit) {
	    	if (this.getCombinedBalance() + deposit < 250000.00) {
	    		return true;
	    	} else {
	    		System.out.println("Total is over 250,000. Can not open a new account");
	    		return false;
	    	}
	    }
}