package com.capgemini.pecuniabank.dao;

import java.time.LocalDate;

import com.capgemini.pecuniabank.dto.Cheque;
import com.capgemini.pecuniabank.util.ChequeRepository;

public class ChequeDao {
	
	public boolean debitUsingCheque(String chequeID, String chequeNum, String chequeAccount, String chequeHolderNmae, String chequeBank, String chequeIFSC, LocalDate chequeIssueDate, String chequeStatus)
	{
		Cheque cheque=new Cheque( chequeID,  chequeNum, chequeAccount,  chequeHolderNmae, chequeBank,  chequeIFSC,  chequeIssueDate, chequeStatus);
		new ChequeRepository (cheque) ;
		return true;
		
		
	}

}
