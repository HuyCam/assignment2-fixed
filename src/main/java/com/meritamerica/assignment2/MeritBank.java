package com.meritamerica.assignment2;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	private static int accIndex = 0;
	
	private int accNumber; 
	private static AccountHolder[] accountHolder = new AccountHolder[10];
	private static CDOffering[] CDOfferings = null;
	
	private static int numbOfAccountHolder = 0;
	
	static void addAccountHolder(AccountHolder accountHolder) {
		MeritBank.numbOfAccountHolder++;
		
		MeritBank.accountHolder[MeritBank.numbOfAccountHolder - 1] = accountHolder;
		
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accountHolder;
	}
	
	public static CDOffering[] getCDOfferings() {
		return CDOfferings;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		double highestYield = 0;
		double tempYield = 0;
		int bestIndex = 0; 		// position of the best offerings in the CDOffering array
		
		// check if the CDOfferings is not null
		if (MeritBank.CDOfferings != null) {
			for (int i=0; i < MeritBank.CDOfferings.length; i++) {
				tempYield = MeritBank.futureValue(depositAmount, CDOfferings[i].getInterestRate(), CDOfferings[i].getTerm());
				if (tempYield > highestYield) {
					highestYield = tempYield;
					bestIndex = i;
				}
			}
			
			return CDOfferings[bestIndex];
		} else {
			return null;
		}
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {

		double highestYield = 0;
		int secondBestI = 0; // second best offer index
		int bestI = 0;
		double secondBestYield = 0;
		double tempYield = 0;
		
		if (MeritBank.CDOfferings != null) {
			for (int i=0; i < MeritBank.CDOfferings.length; i++) {
				tempYield = MeritBank.futureValue(depositAmount, CDOfferings[i].getInterestRate(), CDOfferings[i].getTerm());
				if (tempYield > highestYield) {
					
					// let the second best offer take over the old best offer
					secondBestI = bestI;
					secondBestYield = highestYield;
					
					// the best offer get the new position and value
					highestYield = tempYield;
					bestI = i;
					
				}
			}
			
			return CDOfferings[secondBestI];
		} else {
			return null;
		}
	}
	
	public static void clearCDOfferings() {
		MeritBank.CDOfferings = null;
	}
	
	public static void setCDOfferings(CDOffering[] offerings) {
		CDOfferings = offerings; 
	}
	
	public static long getNextAccountNumber() {
		// get back later
		MeritBank.accIndex++;
		return accIndex;
	}
	
	public static double totalBalances() {
		double total = 0.0;
		
		// total all balances (checking and saving) in every account		
		for (int i=0; i < MeritBank.numbOfAccountHolder; i++) {
			total += MeritBank.accountHolder[i].getCheckingBalance() + MeritBank.accountHolder[i].getCheckingBalance();
		}
		
		return total;
	}
	
	public static double futureValue(double presentValue, double interestRate, int term) {
		double futureVal = presentValue * Math.pow(1 + interestRate, term);
		
		return futureVal;
	}
}
