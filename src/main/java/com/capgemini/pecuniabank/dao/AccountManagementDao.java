package com.capgemini.pecuniabank.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecuniabank.dto.AccountManagement;
import com.capgemini.pecuniabank.util.AccountManagementRepository;

public class AccountManagementDao {
	static List<AccountManagement> accountList=new ArrayList<AccountManagement>();
	
	public  List<AccountManagement> debitUsingCheque()
	{
		
		 
		accountList=new AccountManagementRepository().getAccountList();
		return accountList ;
		
	}
	

}
