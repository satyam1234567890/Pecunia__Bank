package com.capgemini.pecuniabank.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.pecuniabank.dao.AccountManagementDao;
import com.capgemini.pecuniabank.dto.AccountManagement;
import com.capgemini.pecuniabank.util.AccountManagementRepository;

public class DaoTest {

	@Test
	public void accountDebitUsingCheque()
	{
		 List<AccountManagement> accountList=new ArrayList<AccountManagement>();
		 List<AccountManagement> accountList1=new ArrayList<AccountManagement>();
		 accountList1=new AccountManagementDao().debitUsingCheque();
		accountList=new AccountManagementRepository().getAccountList();
		Assertions.assertEquals(accountList1,accountList);
	}
}
