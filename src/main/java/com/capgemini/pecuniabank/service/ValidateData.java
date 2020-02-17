package com.capgemini.pecuniabank.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import com.capgemini.pecuniabank.exception.UserDefineException;


public class ValidateData {
	
	public static String exceptionclass= "UserDefineException : ";
	
	
	 // check the number is numberic or not
	 public static boolean  stringContainsNumber(String accountID) 
	 {
		 return Pattern.compile("[0-9]").matcher(accountID).find();
	 }
	 
	 
	 
	 
	 //validate debit using cheque data
	 public static boolean validateDataDebitUsingCheque(String accountID,double amount,LocalDate  chequeIssueDate,String chequeNum,String chequeIFSC,LocalDate  transcationDate) throws  UserDefineException
	 {
		 
		 if(accountID.length()==12 && stringContainsNumber(accountID) ) 
			{
				if(amount>=100.00&&amount<=200000.00)
				{
					if(chequeNum.length()==6 && stringContainsNumber(chequeNum))
					{
						Period period =  Period.between(chequeIssueDate,transcationDate);
						if(period.getMonths()<3)
						{
							if( chequeIFSC.length()==10)
							{
								return true;
							}
							else
							{
								throw new UserDefineException(exceptionclass+"Invalid IFSC code");
								
							}
						}
						else
						{
							throw new UserDefineException(exceptionclass+"Invalid cheque date");
						}
					}
					else
					{
						throw new UserDefineException(exceptionclass+"Invalid cheque Number");
					}
				}
				else
				{
					throw new UserDefineException(exceptionclass+"Invalid cheque amount");
				}
			}
		 else
		 {
			 throw new UserDefineException(exceptionclass+"Invalid accountId");
		 }
		 
	 }
	 
	 
	//validate credit using cheque data
		public static boolean validateDataCreditUsingCheque(String accountID, double amount,String chequeNum,String chequeAccount,String chequeIFSC,LocalDate  chequeIssueDate,LocalDate  transcationDate) throws UserDefineException
		{
			if(accountID.length()==12 && stringContainsNumber(accountID) ) 
			{
				if(chequeAccount.length()==12 && stringContainsNumber(chequeAccount))
				{
				if(amount>=100.00 && amount<=200000.00)
				{
					if(chequeNum.length()==6 && stringContainsNumber(chequeNum))
					{
						Period period =  Period.between(chequeIssueDate,transcationDate);
						if(period.getMonths()<3)
						{
							if( chequeIFSC.length()==10)
							{
								return true;
							}
							else
							{
								throw new UserDefineException(exceptionclass+"Invalid IFSC code");
								
							}
						}
						else
						{
							throw new UserDefineException(exceptionclass+"Invalid cheque date");
						}
					}
					else
					{
						throw new UserDefineException(exceptionclass+"Invalid cheque Number");
					}
				}
				else
				{
					throw new UserDefineException(exceptionclass+"Invalid cheque amount");
				}
			}
			else
			{
				 throw new UserDefineException(exceptionclass+"Invalid cheque Account");
			}
			}
		 else
		 {
			 throw new UserDefineException(exceptionclass+"Invalid accountId");
		 }
		}
	 

}
