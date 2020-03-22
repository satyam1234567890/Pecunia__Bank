package com.capgemini.pecuniabank.dao;


import java.time.LocalDate;

import com.capgemini.pecuniabank.dto.Transcation;
import com.capgemini.pecuniabank.util.TranscationRepository;

public  interface TranscationDao  {
	
	public boolean debitUsingCheque(String transID, String accountID, String transType, double amount, String transOption, LocalDate transcationDate, String chequeID, String transto, String transfrom, double closingBalance);
	

	

}
