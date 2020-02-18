package com.capgemini.pecuniabank.ui;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Logger;

import com.capgemini.pecuniabank.exception.UserDefineException;
import com.capgemini.pecuniabank.service.ChequeService;
import com.capgemini.pecuniabank.service.ChequeServiceImp;

public class Client {
	
	public static void main(String ar[])
	{
		
		 Logger logger
         = Logger.getLogger( 
             Client.class.getName()); 
		 
		String employeeID;
		String password;
		
		Scanner sc=new Scanner(System.in);
		
		ChequeService chequeservice=new ChequeServiceImp(); 
		
		//employeeid=satyamPUNB and password=PUNBsatyam are given to the employee by admistartion.
		
		logger.info ("Enter EmployeeID: ");
		employeeID=sc.next();
		
		logger.info ("Enter Password: ");
		password=sc.next();
		
		if(employeeID.equals("satyamPUNB") && password.equals("PUNBsatyam"))
		{
		 do {
			int option;
			logger.info ("1. debit  using cheque");
			logger.info ("2. credit using cheque");
			logger.info ("enter your chooes : ");
			option=sc.nextInt();
			switch(option)
			{
			case 1:
					{
						logger.info ("enter accountID : ");
						String accountID=sc.next();
						
						logger.info ("enter amount : ");
						double amount=sc.nextDouble();
						
						logger.info ("enter chequeIssueDate :yyyy,MM,DD ");  //cheque date
						String []data;
						String sdate=sc.next();
						data=sdate.split(",");
						int year = Integer.parseInt( data[0] );
						int month = Integer.parseInt( data[1] );  
						int day = Integer.parseInt( data[2] );
						LocalDate chequeIssueDate = LocalDate.of(year,month,day);
						
						logger.info ("enter checkNum : ");
						String chequeNum = sc.next();
						
						logger.info ("enter chequeAccount: ");
						String chequeAccount = sc.next();
						
						logger.info ("enter chequeBank: ");      //same bank cheque
						String chequeBank = sc.next();
						
						logger.info ("enter chequeHolderName: ");
						String chequeHolderName = sc.next();
						
						logger.info ("enter chequeIFSC: ");
						String chequeIFSC = sc.next();
						
						logger.info ("enter chequeStatus: ");     //unpaid or paid
						String chequeStatus = sc.next();
						
						logger.info ("enter transcationDate: ");  //debating money date from bank 
						LocalDate transcationDate =  LocalDate.now();
						
						try {
							chequeservice.debitUsingCheque(accountID,amount, chequeIssueDate, chequeNum,
								 chequeAccount, chequeBank, chequeHolderName, chequeIFSC,  chequeStatus,
									 transcationDate);
						} catch (UserDefineException e) {
							
							logger.info(""+e);
						}
						
						
						
					}
				break;
			case 2:
					{
						logger.info ("enter accountID : "); //beneficiary account no
						String accountID=sc.next();
						
						logger.info ("enter amount : ");
						double amount=sc.nextDouble();
						
						LocalDate transcationDate=LocalDate.now();
						
						logger.info ("enter chequeNumber : ");
						String chequeNum=sc.next();
						
						logger.info ("enter chequeAccount : "); //payee account no
						String chequeAccount=sc.next();
						
						logger.info ("enter chequeAccount : "); //we have only deals within the bank itself
						String chequeBankName=sc.next();
						
						logger.info ("enter chequeHolderName : ");
						String chequeHolderName=sc.next();
						
						logger.info ("enter chequeIFSC : ");
						String chequeIFSC=sc.next();
						
						logger.info ("enter chequeIssueDate : yyyy,MM,DD"); 
						String []data;
						String sdate=sc.next();
						data=sdate.split(",");
						int year = Integer.parseInt( data[0] ); 
						int month = Integer.parseInt( data[1] );  
						int day = Integer.parseInt( data[2] );
						LocalDate  chequeIssueDate=LocalDate.of(year,month,day);
						
						logger.info ("enter chequestatus : ");//paid or unpaid
						String chequeStatus=sc.next();
						
						try {
							chequeservice.creditUsingCheque(accountID,  amount,   transcationDate,  chequeNum,
									 chequeAccount, chequeBankName,  chequeHolderName,  chequeIFSC,
									  chequeIssueDate, chequeStatus);
						} catch (UserDefineException e) {
							
							logger.info(""+e);
						}
						
					}
				break;
			default:
					{
						logger.info ("Invalid option");
					}
				break;
			}
		 
		}while(true);
		}
	else
		{
			logger.info ("Your Id or password are invalid ");
		}
		
		
		sc.close(); //close scanner 
		
	}

}

