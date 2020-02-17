package com.capgemini.pecuniabank.dto;

import java.time.LocalDate;
import java.util.Date;

public class Cheque {
	String chequeID;
	int  chequeNum;
	String chequeAccountNo;
	String chequeHolderName;
	String chequeBankName;
	String chequeIFSC;
	LocalDate  chequeIssueDate;
	String chequeStatus;
	public Cheque(String chequeID, String chequeNum, String chequeAccount, String chequeHolderName, String chequeBank,
			String chequeIFSC, LocalDate chequeIssueDate, String chequeStatus) {

		this.chequeID=chequeID;
		this.chequeNum=Integer.parseInt(chequeNum);
		this.chequeAccountNo=chequeAccount;
		this.chequeHolderName=chequeHolderName;
		this.chequeBankName=chequeBank;
		this.chequeIFSC=chequeIFSC;
		this.chequeIssueDate=chequeIssueDate;
		this.chequeStatus=chequeStatus;
		
	}
	/*
	public String getChequeID() {
		return chequeID;
	}
	public void setChequeID(String chequeID) {
		this.chequeID = chequeID;
	}
	public int getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(int chequeNum) {
		this.chequeNum = chequeNum;
	}
	public String getChequeAccountNo() {
		return chequeAccountNo;
	}
	public void setChequeAccountNo(String chequeAccountNo) {
		this.chequeAccountNo = chequeAccountNo;
	}
	public String getChequeHolderName() {
		return chequeHolderName;
	}
	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	public String getChequeIFSC() {
		return chequeIFSC;
	}
	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}
	public LocalDate  getChequeIssueDate() {
		return chequeIssueDate;
	}
	public void setChequeIssueDate(LocalDate  chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}
	public String getChequeStatus() {
		return chequeStatus;
	}
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	*/
	@Override
	public String toString()
	{
		return chequeID+" "+chequeNum;
	}

}
