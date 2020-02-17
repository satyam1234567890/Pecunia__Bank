package com.capgemini.pecuniabank.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.pecuniabank.exception.UserDefineException;
import com.capgemini.pecuniabank.service.ChequeService;
import com.capgemini.pecuniabank.service.ChequeServiceImp;
import com.capgemini.pecuniabank.service.ValidateData;

public class CheckServiceImpTest {
	
	ChequeService chequeservice=new ChequeServiceImp();
	
	
//debitCheque testing:-	
//function execute successfully		
	@Test
	public void checkDebitUsingChequeTest() throws UserDefineException 
	{
		
			Assertions.assertTrue(chequeservice.debitUsingCheque("328287420931",5000.00, LocalDate.of(2020,02,04), "420931",
					 "328287420931", "pecuniabank", "Vishal2093", "PUNBO33950",  "unknown",
					 LocalDate.now()).equals("Transcation  completed"));
		
	}
	
	
	
//validation account id
	@Test
	public void checkDebitUsingCheque1Test()
	{
		
		try {
			chequeservice.debitUsingCheque("428287420931",5000.00, LocalDate.of(2020,02,04), "420931",
					"328287420931", "pecuniabank", "Vishal2093", "PUNBO33950",  "unknown",
					LocalDate.now());
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"InvalidAccountException :428287420931");
			
		}
	}
	
	
	
// validation cheque issue date
	@Test
	public void checkDebitUsingCheque2Test()
	{
		
		try {
		chequeservice.debitUsingCheque("328287420931",5000.00, LocalDate.of(2019,10,04), "420931",
					"328287420931", "pecuniabank", "Vishal2093", "PUNBO33950",  "unknown",
					LocalDate.now());
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque date");
		}
	}
	
	
//validation cheque num
	
	@Test
	public void checkDebitUsingCheque3Test()
	{
		
		try {
			chequeservice.debitUsingCheque("328287420931",5000.00, LocalDate.of(2020,02,04), "420931223",
					"328287420931", "pecuniabank", "Vishal2093", "PUNBO33950",  "unknown",
					LocalDate.now());
		} catch (UserDefineException e) { 
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque Number");
		}
	}
	
	
//validation amount**
	@Test
	public void checkDebitUsingCheque4Test() 
	{
		try {
			chequeservice.debitUsingCheque("328287420931",1105000.00, LocalDate.of(2020,02,04), "420931",
					 "328287420931", "pecuniabank", "Vishal2093", "PUNBO33950",  "unknown",
					 LocalDate.now());
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque amount");
		}
	}
	
	
	
//validation  IFSC code
	@Test
	public void checkDebitUsingCheque5Test()
	{
		
		try {
			chequeservice.debitUsingCheque("328287420931",15000.00, LocalDate.of(2020,02,04), "420931",
					"328287420931", "pecuniabank", "Vishal2093", "PUNBO3395000",  "unknown",
					LocalDate.now());
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid IFSC code");
		}
	}
	
	
//account validation
	@Test
	public void checkDebitUsingCheque6Test()
	{
		
		try {
			chequeservice.debitUsingCheque("4282874209",5000.00, LocalDate.of(2020,02,04), "420931",
					"328287420931", "pecuniabank", "Vishal2093", "PUNBO33950",  "unknown",
					LocalDate.now());
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),ValidateData.exceptionclass+"Invalid accountId");
		}
	}
	
	
//low balance 		
	@Test
	public void checkDebitUsingCheque7Test() 
	{
		try {
		chequeservice.debitUsingCheque("429868430211",115000.00, LocalDate.of(2020,02,04), "420931",
					 "429868430211", "pecuniabank", "Vishali3012", "PUNBO33950",  "unknown",
					 LocalDate.now());
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"InsufficientBalance :115000.0");
		}
	}
	
	
	
	
	
	
	
//creditCheque testing:-
		
//function execute successfully		
	@Test
	public void checkcreditUsingChequeTest() throws UserDefineException
	{
		
			Assertions.assertTrue(chequeservice.creditUsingCheque("328287420931",5000.00,LocalDate.now(),"118471",  
					 "243902118471", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2020,02,04), "unknown"
					 ).equals("Transcation  completed"));
		
	}
	
	

	
//account validation
	@Test
		public void checkCreditUsingCheque2Test()
		{
			
			try {
				chequeservice.creditUsingCheque("32828742093111",5000.00,LocalDate.now(),"118471",  
						 "243902118471", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
			} catch (UserDefineException e) {
				// TODO Auto-generated catch block
				assertEquals(e.getMessage(),ValidateData.exceptionclass+"Invalid accountId");
			}
		}
	
	
//cheque amount validation
	@Test
	public void checkcreditUsingCheque3Test()
	{
		try {
		chequeservice.creditUsingCheque("328287420931",50000000.00,LocalDate.now(),"118471",  
					 "243902118471", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque amount");
		}
	}

	
//cheque num validation
	@Test
	public void checkCreditUsingCheque4Test()
	{
		
		try {
			chequeservice.creditUsingCheque("328287420931",5000.00,LocalDate.now(),"1184712",  
					 "243902118471", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque Number");
		}
	}
	

//cheque account validation
	@Test
	public void checkCreditUsingCheque5Test()
	{
		
		try {
			chequeservice.creditUsingCheque("328287420931",5000.00,LocalDate.now(),"118471",  
					 "24390211847122", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque Account");
		}
	}
		
		
//cheque IFSC code validation
		
	@Test
	public void checkCreditUsingCheque6Test()
	{
		
		try {
			chequeservice.creditUsingCheque("328287420931",5000.00,LocalDate.now(),"118471",  
					 "243902118471", "pecuniabank", "Parnav1874", "PUNBO3395000", LocalDate.of(2020,02,04), "unknown");
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid IFSC code");
		}
	}
	
	
		
//cheque issue date validation***
	@Test
	public void checkcreditUsingCheque7Test()
	{
		try {
			chequeservice.creditUsingCheque("328287420931",5000.00,LocalDate.now(),"118471",  
					 "243902118471", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2019,10,04), "unknown"
					 );
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"UserDefineException : Invalid cheque date");
			
		}
	}
	
	
//invalid account test
	@Test
	public void checkCreditUsingCheque8Test()
	{
		
		try {
			chequeservice.creditUsingCheque("528287420931",5000.00,LocalDate.now(),"118471",  
					 "443902118471", "pecuniabank", "Parnav1874", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			assertEquals(e.getMessage(),"InvalidAccountException :528287420931");
		}
	}
		
		
// less bank balance
		@Test
		public void checkCreditUsingCheque9Test()
		{
			
			try {
				chequeservice.creditUsingCheque("528287420931",15000.00,LocalDate.now(),"118471",  
						 "298744987141", "pecuniabank", "Satyam8714", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
			} catch (UserDefineException e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
				assertEquals(e.getMessage(),"InsufficientBalance :15000.0");
			}
		}
		
		

	
	// different bank
		@Test
		public void checkCreditUsingCheque11Test()
		{
			
			try {
				chequeservice.creditUsingCheque("528287420931",15000.00,LocalDate.now(),"118471",  
						 "298744987141", "pecuniaBank", "Satyam8714", "PUNBO33950", LocalDate.of(2020,02,04), "unknown");
			} catch (UserDefineException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}		
	
//check account id is numeric
	@Test
	public void stringContainsNumberTest()
	{
		Assertions.assertTrue(ValidateData.stringContainsNumber("528287420931") ==true);
	}
	
//validated function
	
	@Test
	public void  validateDataDebitUsingChequeTest()
	{
		
		try {
			Assertions.assertTrue(ValidateData. validateDataDebitUsingCheque("328287420931", 5000.00, LocalDate.of(2020,02,04),"118471", "PUNBO33950",  LocalDate.now()));
		} catch (UserDefineException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
		}
	}
	

}
