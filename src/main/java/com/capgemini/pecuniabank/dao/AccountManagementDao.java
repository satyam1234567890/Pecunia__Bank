package com.capgemini.pecuniabank.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecuniabank.dto.AccountManagement;
import com.capgemini.pecuniabank.util.AccountManagementRepository;

public interface AccountManagementDao {
	public  List<AccountManagement> debitUsingCheque();
	

}
