package com.capgemini.pecuniabank.dao;

import java.time.LocalDate;

import com.capgemini.pecuniabank.dto.Cheque;
import com.capgemini.pecuniabank.util.ChequeRepository;

public interface ChequeDao {
	
	public boolean debitUsingCheque(String chequeID, String chequeNum, String chequeAccount, String chequeHolderNmae, String chequeBank, String chequeIFSC, LocalDate chequeIssueDate, String chequeStatus);//cheque data

}
