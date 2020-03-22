package com.capgemini.pecuniabank.service;

import java.time.LocalDate;

import com.capgemini.pecuniabank.exception.UserDefineException;


public interface ChequeService {
	public abstract String debitUsingCheque(String accountID,double amount,LocalDate  chequeIssueDate ,String chequeNum,String chequeAccount,String chequeBank,String chequeHolderName,String chequeIFSC,String chequeStatus,LocalDate  transcationDate) throws UserDefineException;
	public abstract String creditUsingCheque(String accountID,double amount,LocalDate  transcationDate,String chequeNum,String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,LocalDate  chequeIssueDate,String chequeStatus ) throws UserDefineException;

}
