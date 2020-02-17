package com.capgemini.pecuniabank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.capgemini.pecuniabank.dao.AccountManagementDao;
import com.capgemini.pecuniabank.dao.ChequeDao;
import com.capgemini.pecuniabank.dao.TranscationDao;
import com.capgemini.pecuniabank.dto.AccountManagement;
import com.capgemini.pecuniabank.exception.UserDefineException;

public class ChequeServiceImp implements ChequeService {
	 Random random=new Random();  //for generate chequeID and transcationID
	 boolean check1=true;
	 boolean check2=false;
	 Logger logger
     = Logger.getLogger( 
    		 ChequeServiceImp.class.getName()); 
	 
	 AccountManagementDao accountManagementDao=new AccountManagementDao();
	 
	static  List<AccountManagement> accountList=new ArrayList<AccountManagement>();
	
	 
	 
	 // check the account is exist or not in account management repository
	 public boolean checkAccountExits(String accountID )
	 { 
		 for(AccountManagement accountuser:accountList)
			{
				
				if(accountID.equals(accountuser.getAccountID()))
				{
					return true;
				}
				
			}
		return false;
	 }
	 
	 
	 
	 //get the user account object from the AccountManagementRepositry list
	 public AccountManagement getAccountObject(String accountID)
	 {
		 for(AccountManagement accountuser:accountList)
			{
				
				if(accountID.equals(accountuser.getAccountID()))
				{
					return accountuser;
				}
				
			}
		return null;
	 }
	 
	 
	 
	 
	 
	 
	 //check balance
	 public boolean isSufficentBalance(double amount, AccountManagement user ) 
	 {
		 
		 return (amount<=user.getAccountBalance()?check1:check2);
		 
	 }
	 
	 
	 
	 //remaining balance
	 public double closingBalance(double amount,AccountManagement user)
	 {
		 return (user.getAccountBalance()-amount);
	 }
	 
	 
	
	 //generate chequeid
	 public String  generateChequeId()
	 {
		
		int chequeId=random.nextInt(999999);
		return ""+chequeId;
		 
	 }
	 
	 
	 //generate transcationid
	 public String  generatetransId()
	 {
		 
		  int transId=random.nextInt(999999);
		return ""+transId;
		 
	 }
	 
	 

	 //debit using cheque

	 public String debitUsingCheque(String accountID, double amount, LocalDate  chequeIssueDate, String chequeNum,
			String chequeAccount, String chequeBank, String chequeHolderNmae, String chequeIFSC, String chequeStatus,
			LocalDate  transcationDate) throws UserDefineException {
		
		    if( (ValidateData.validateDataDebitUsingCheque( accountID, amount, chequeIssueDate, chequeNum, chequeIFSC,  transcationDate)))
				{
		    	
				accountList=accountManagementDao.debitUsingCheque();
				
						if(!(checkAccountExits(accountID )))
							{
								throw new UserDefineException("InvalidAccountException :"+accountID);
							}
				        else
				           {
					 
					          AccountManagement user=getAccountObject(accountID);
					 
					          if(!(isSufficentBalance(amount,user )) )
					             {
									    String chequeStatus4="Bounced";
									    chequeStatus=chequeStatus4;
									    String  chequeID=null;
									 //add the information to repo
						 
					                   ChequeDao chequedao=new  ChequeDao();
					                   
											 if(chequedao.debitUsingCheque(chequeID,chequeNum,chequeAccount,chequeHolderNmae,chequeBank,chequeIFSC,chequeIssueDate,chequeStatus)==check1)
													 {
														logger.info("add in cheque repo");
													 }
						                      throw new UserDefineException("InsufficientBalance :"+amount);
						  
					              }
								else
								  {
									  //set update balance
									  double rBalance= closingBalance(amount,user);
									  
										user.setAccountBalance(rBalance);
										 
										String chequeStatus5="Cleared";
										chequeStatus=chequeStatus5;
										
										 String  chequeID=generateChequeId();
										 
										 //add the information to repo
										 ChequeDao chequedao=new  ChequeDao();
										 
												 if(chequedao.debitUsingCheque(chequeID,chequeNum,chequeAccount,chequeHolderNmae,chequeBank,chequeIFSC,chequeIssueDate,chequeStatus)==check1)
					                                {
													 logger.info("cheque information add scuessfully");
					                                }
											 
												 
												 
											 //add data in transcation repository
											 TranscationDao transcationdao=new TranscationDao();
											 String transID=generatetransId();
											 String data="cheque";
											 String transType=data;
											 String transOption=data;
											 String transto=chequeHolderNmae;
											 String transfrom="self";
											
											 
																	 //set information to repo
													if(( transcationdao.debitUsingCheque(transID,accountID,transType,amount,transOption,transcationDate,chequeID,transto,transfrom, rBalance)))
													{
														logger.info("transcation data added");
													}
													
							 return "Transcation  completed";
					  }
		       }
		}
			
		return "Transcation not  completed";
		     
		
	}	
	
	
	
	
	//creditClosingBalance
	public double creditClosingBalance(double amount,AccountManagement user)
	{
		return amount+user.getAccountBalance();
	}
	
	
	
	
	//credit using cheque 
	public String creditUsingCheque(String accountID, double amount, LocalDate  transcationDate, String chequeNum,
			String chequeAccount, String chequeBankName, String chequeHolderName, String chequeIFSC,
			LocalDate  chequeIssueDate, String chequeStatus) throws UserDefineException {
		
		
		
			if((ValidateData.validateDataCreditUsingCheque(accountID,  amount, chequeNum, chequeAccount, chequeIFSC,  chequeIssueDate, transcationDate)) )
			{
				accountList=accountManagementDao.debitUsingCheque();
				
					if(!(checkAccountExits(accountID ))&&!(checkAccountExits(chequeAccount )))
					{
						throw new UserDefineException ("InvalidAccountException :"+accountID);
					}
					
					else
					{
						  AccountManagement payee=getAccountObject(chequeAccount);
						  AccountManagement benificary= getAccountObject(accountID);
							 
							
								 
							 
							  if(!(isSufficentBalance(amount,payee)) )
							  {
								  String chequeStatus1="Bounced";
								  chequeStatus=chequeStatus1;
								    String  chequeID=null;
								 //add the information to repo
								 
								   ChequeDao chequedao=new  ChequeDao();
										 if(chequedao.debitUsingCheque(chequeID,chequeNum,chequeAccount,chequeHolderName,chequeBankName,chequeIFSC,chequeIssueDate,chequeStatus)==check1)
										 {
											 logger.info("add in cheque repo");
										 }
								 throw new UserDefineException("InsufficientBalance :"+amount); 
							  }
							  else
							  {
								  double rBalance= closingBalance(amount,payee);
									payee.setAccountBalance(rBalance);
									benificary.setAccountBalance(creditClosingBalance(amount,benificary));
									if(chequeBankName.equals("pecuniaBank"))
									{
										String chequeStatus2="Cleared";
									    chequeStatus=chequeStatus2;
									}
									 else
									 {
										String chequeStatus3="pending" ;
										chequeStatus=chequeStatus3;
									 }
									 String  chequeID=generateChequeId();
									 //add the information to repo
									 ChequeDao chequedao=new  ChequeDao();
									 if((chequedao.debitUsingCheque(chequeID,chequeNum,chequeAccount,chequeHolderName,chequeBankName,chequeIFSC,chequeIssueDate,chequeStatus)))
		                                {
		                                logger.info("cheque information add scuessfully");
		                                }
									 
									//add data in transcation repository
									 TranscationDao transcationdao=new TranscationDao();
									 String transID=generatetransId();
									 String transType="cheque";
									 String transOption="cheque";
									 String transto=chequeHolderName;
									 String transfrom="self";

									 //set information to repo
									if( transcationdao.debitUsingCheque(transID,accountID,transType,amount,transOption,transcationDate,chequeID,transto,transfrom, rBalance))
									{
										 logger.info("transcation data added");
									}
									 return "Transcation  completed";
								  
							  }
					
					}
			
			}
		
		
		
		return "Transcation not completed";
	}
	
	

	

}
