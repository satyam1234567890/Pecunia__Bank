package com.capgemini.pecuniabank.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecuniabank.dto.AccountManagement;
import com.capgemini.pecuniabank.dto.Cheque;
import com.capgemini.pecuniabank.dto.Transcation;
import com.capgemini.pecuniabank.util.AccountManagementRepository;
import com.capgemini.pecuniabank.util.ChequeRepository;
import com.capgemini.pecuniabank.util.TranscationRepository;

public class DaoService implements TranscationDao,ChequeDao,AccountManagementDao {
	
static List<AccountManagement> accountList=new ArrayList<AccountManagement>();
	
	public  List<AccountManagement> debitUsingCheque()
	{
		
		 
		accountList=new AccountManagementRepository().getAccountList();
		return accountList ;
		
	}
	public boolean debitUsingCheque(String transID, String accountID, String transType, double amount, String transOption, LocalDate transcationDate, String chequeID, String transto, String transfrom, double closingBalance)
	{
		Transcation transcation =new Transcation(transID,accountID,transType,amount,transOption,transcationDate,chequeID,transto,transfrom,closingBalance);
		new TranscationRepository (transcation);
		return true;
		
		
	}
	
	public boolean debitUsingCheque(String chequeID, String chequeNum, String chequeAccount, String chequeHolderNmae, String chequeBank, String chequeIFSC, LocalDate chequeIssueDate, String chequeStatus)
	{
		Cheque cheque=new Cheque( chequeID,  chequeNum, chequeAccount,  chequeHolderNmae, chequeBank,  chequeIFSC,  chequeIssueDate, chequeStatus);
		new ChequeRepository (cheque) ;
		return true;
		
		
	}
}
