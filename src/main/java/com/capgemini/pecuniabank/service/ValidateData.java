package com.capgemini.pecuniabank.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.capgemini.pecuniabank.exception.UserDefineException;
import com.capgemini.pecuniabank.ui.Client;


public class ValidateData {
	
	public static String exceptionclass= "UserDefineException : ";
	
	 static Logger logger
     = Logger.getLogger( 
         Client.class.getName()); 
	 // check the number is numberic or not
	 public static boolean  stringContainsNumber(String accountID) 
	 {
		 return Pattern.compile("[0-9]").matcher(accountID).find();
	 }
	 
	 
	
	 
	 //validate debit using cheque data
	 public static boolean validateDataDebitUsingCheque(String accountID,double amount,LocalDate  chequeIssueDate,String chequeNum,String chequeIFSC,LocalDate  transcationDate) throws  UserDefineException
	 {
		 
		 if(accountID.length()==12 && stringContainsNumber(accountID) ); 
		 else
		 {
			 logger.info ("AccountId should contain numeric value and length=12 ");
			 throw new UserDefineException(exceptionclass+"Invalid accountId");
		 }
		 if(amount>=100.00&&amount<=200000.00);
		else
			{
			 logger.info ("amount in between 100 to 2 lakhs ");
				throw new UserDefineException(exceptionclass+"Invalid cheque amount");
			}
		 if(chequeNum.length()==6 && stringContainsNumber(chequeNum));
			else
			{
				 logger.info ("cheque number should be integer and length=6 ");
				throw new UserDefineException(exceptionclass+"Invalid cheque Number");
			}
		 
			Period period =  Period.between(chequeIssueDate,transcationDate);
				if(period.getMonths()<3);
				else
				{
					 logger.info ("wthin in 3 month ");
					throw new UserDefineException(exceptionclass+"Invalid cheque date");
				}
				
				if( chequeIFSC.length()==10);
				else
				{
					 logger.info ("IFSC code is alpha numeric length=10 ");
					throw new UserDefineException(exceptionclass+"Invalid IFSC code");
					
				}
				return true;
		
		 
	 }
	 
	 
	//validate credit using cheque data
		public static boolean validateDataCreditUsingCheque(String accountID, double amount,String chequeNum,String chequeAccount,String chequeIFSC,LocalDate  chequeIssueDate,LocalDate  transcationDate) throws UserDefineException
		{
		if(accountID.length()==12 && stringContainsNumber(accountID) ) ;
		 else
		 {
			 logger.info ("AccountId should contain numeric value and length=12 ");
			 throw new UserDefineException(exceptionclass+"Invalid accountId");
		 }

		if(chequeAccount.length()==12 && stringContainsNumber(chequeAccount));
		else
		{
			 logger.info ("chequeAccount should contain numeric value and length=12 ");
			 throw new UserDefineException(exceptionclass+"Invalid cheque Account");
		}
		if(amount>=100.00 && amount<=200000.00);
		else
		{
			logger.info ("amount in between 100 to 2 lakhs ");
			throw new UserDefineException(exceptionclass+"Invalid cheque amount");
		}
		if(chequeNum.length()==6 && stringContainsNumber(chequeNum));
		else
		{
			 logger.info ("cheque number should be integer and length=6 ");
			throw new UserDefineException(exceptionclass+"Invalid cheque Number");
		}
		Period period =  Period.between(chequeIssueDate,transcationDate);
		if(period.getMonths()<3);
		else
		{
			 logger.info ("wthin in 3 month ");
			throw new UserDefineException(exceptionclass+"Invalid cheque date");
		}
		if( chequeIFSC.length()==10);
		else
		{
			 logger.info ("IFSC code is alpha numeric length=10 ");
			throw new UserDefineException(exceptionclass+"Invalid IFSC code");
			
		}
	return true;
			
		
	}

}
