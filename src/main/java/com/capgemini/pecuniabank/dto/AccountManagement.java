package com.capgemini.pecuniabank.dto;


import java.time.LocalDate;
import java.util.Date;

public class AccountManagement {
	private String accountID;
	private String accountHolderID;
	private String accountBranchID;
	private String accountType;
	private String accountStatus;
	private double accountBalance;
	private double accountInterest;
	 private LocalDate  lastUpadte;
	
	public AccountManagement(String accountID, String accountHolderID, String accountBranchID, String accountType,
			String accountStatus,double accountBalance, double accountInterest, LocalDate  lastUpadte) {
		this.accountID = accountID;
		this.accountHolderID = accountHolderID;
		this.accountBranchID = accountBranchID;
		this.accountType = accountType;
		this.accountStatus=accountStatus;
		this.accountBalance = accountBalance;
		this.accountInterest = accountInterest;
		this.lastUpadte = lastUpadte;
	}

	public String getAccountID() {
		return accountID;
	}
/*
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountHolderID() {
		return accountHolderID;
	}

	public void setAccountHolderID(String accountHolderID) {
		this.accountHolderID = accountHolderID;
	}

	public String getAccountBranchID() {
		return accountBranchID;
	}

	public void setAccountBranchID(String accountBranchID) {
		this.accountBranchID = accountBranchID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}*/

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
/*
	public double getAccountInterest() {
		return accountInterest;
	}

	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}

	public LocalDate  getLastUpadte() {
		return lastUpadte;
	}

	public void setLastUpadte(LocalDate  lastUpadte) {
		lastUpadte = lastUpadte;
	}

	
*/
	
	

}
