package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		// i
		CDOffering[] offerings = new CDOffering[5];

    	offerings[0] = new CDOffering(1,1.8/100);
    	offerings[1] = new CDOffering(2,1.9/100);
    	offerings[2] = new CDOffering(3,2.0/100);
    	offerings[3] = new CDOffering(5,2.5/100);
    	offerings[4] = new CDOffering(10,2.2/100);
    	
    	MeritBank.setCDOfferings(offerings);
    	
    	// ii
    	AccountHolder ah1 = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	// iii
    	ah1.addCheckingAccount(1000);
    	ah1.addSavingsAccount(10000);
    	
    	// iv
    	ah1.addCheckingAccount(5000);
    	ah1.addSavingsAccount(50000);
    	
    	// v
    	ah1.addCheckingAccount(50000);
    	ah1.addSavingsAccount(500000);
    	
    	// vi
    	ah1.addCheckingAccount(new CheckingAccount(5000));
    	ah1.addSavingsAccount(new SavingsAccount(50000));
    	
    	// viii
    	CDAccount cd1 = new CDAccount(MeritBank.getBestCDOffering(10000), 10000);
    	
    	ah1.addCDAccount(cd1);
    	
    	// ix.
    	MeritBank.addAccountHolder(ah1);
    	
    	// x
    	AccountHolder ah2 = new AccountHolder("David", "Luke", "Houston","123457896");
    	
    	// xi
    	ah2.addCheckingAccount(1000);
    	ah2.addSavingsAccount(10000);
    	
    	// xii
    	CDAccount cd2 = new CDAccount(MeritBank.getSecondBestCDOffering(10000), 10000);
    	ah2.addCDAccount(cd2);
    	
    	// xiii
    	MeritBank.addAccountHolder(ah2);
    	
    	// xiv
    	MeritBank.clearCDOfferings();
    	
    	// xv
    	AccountHolder ah3 = new AccountHolder("James", "Koski", "Dallas", "987653214");
    	
    	// xvi
    	CDAccount cd3 = new CDAccount(MeritBank.getSecondBestCDOffering(15000), 15000);
    	
    	ah3.addCDAccount(cd3);
    	
    	// xvii
    	
    	// xviii
    	ah3.addCheckingAccount(1000);
    	ah3.addSavingsAccount(10000);
    	
    	// xix
    	MeritBank.addAccountHolder(ah3);
    	
    	// xix
    	System.out.println(MeritBank.totalBalances());
    	
    	
	}
}