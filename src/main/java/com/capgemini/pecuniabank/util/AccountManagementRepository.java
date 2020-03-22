package com.capgemini.pecuniabank.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecuniabank.dto.AccountManagement;

public class AccountManagementRepository {
	 static List <AccountManagement> accountUsers=new ArrayList<AccountManagement>();
	 String accountStatus="Active";
	 String IFSC="PUNBO33950";
	 String accountType="current";
	public AccountManagementRepository()
	{
	
		accountUsers.add(new AccountManagement( "328287420931","Vishal2093",IFSC,accountType,accountStatus,272000.00,3.00,LocalDate.of(2010,02,11)));
		accountUsers.add(new AccountManagement( "429868430211","Vishali3012",IFSC,accountType,accountStatus,89000.00,3.50,LocalDate.of(2020,01,29)));
		accountUsers.add(new AccountManagement( "431032981981","Amardeep8198",IFSC,accountType,accountStatus,20000.00,3.50,LocalDate.of(2020,02,01)));
		accountUsers.add(new AccountManagement( "243902118471","Parnav1874",IFSC,accountType,accountStatus,38000.00,3.00,LocalDate.of(2020,02,03)));
		accountUsers.add(new AccountManagement( "298744987141","Satyam8714",IFSC,accountType,accountStatus,5000.00,3.50,LocalDate.of(2020,02,03)));
		accountUsers.add(new AccountManagement( "398714982911","Prabhjot8291",IFSC,accountType,"Closed",0.00,0.00,LocalDate.of(2020,02,12)));
	}
	
	public List <AccountManagement> getAccountList()
	{
		return accountUsers;
	}
	
	
	


}
