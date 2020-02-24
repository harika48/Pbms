package sprint1.pbms.ui;

import java.util.Scanner;

import exception.AccountException;
import exception.AmountLessException;
import sprint1.pbms.dao.TransactionDao;
import sprint1.pbms.dao.TransactionDaoImpl;
import sprint1.pbms.service.TransactionService;
import sprint1.pbms.service.TransactionServiceImpl;
 
import sprint1.pbms.model.TransactionUsingSlip;

public class TransactionUI {
	static TransactionDao transactiondao=new TransactionDaoImpl();
	//  static TransactionUsingSlip c=new TransactionUsingSlip();
	static TransactionService ts=new TransactionServiceImpl();
	static Scanner in=new Scanner(System.in);
	public static void main(String[]args) {
		for(;;) {
			int choice = 0;
			System.out.println("Enter your choice");
			System.out.println("1.Credit using slip");
			System.out.println("2.Debit using slip");
			System.out.println("3.Exit");
			try {
				choice=in.nextInt();
			in.nextLine();
			}catch(Exception e) {
				System.out.println("Please enter correct option");
				in.nextLine();
			}
			
			switch(choice) {
			case 1:
				try {
				creditUsingSlipInfo();}
				catch(Exception e) {
					System.out.println(e.getMessage());
					
				}
				break;
			case 2:try {
				debitUsingSlipInfo();}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
					System.exit(0);
					break;
			 default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	public static void creditUsingSlipInfo() throws AccountException, AmountLessException {
		System.out.println("Enter user name");
		String userName=in.next()+in.nextLine();
		System.out.println("enter account number");
		String accountNumber=in.next();
		System.out.println("enter amount to be credited");
		int amount=in.nextInt();
		 boolean isValidAccountNumber=((TransactionServiceImpl) ts).isValidAccountNumber( accountNumber);
		 boolean isValidAmount=((TransactionServiceImpl) ts).isValidAmount( amount);
		 if((isValidAccountNumber==true) && (isValidAmount==true)){
		 
		if(transactiondao.creditUsingSlip( userName, accountNumber,amount)) 
			System.out.println("Amount deposited successfully");
		else
			throw new AmountLessException("please enter the amount in the valid range");
	 }
	
	 else
			throw new AccountException("Please enter valid input details");
	}
	
	public static void debitUsingSlipInfo() throws AmountLessException, AccountException {
		System.out.println("Enter user name");
		String userName=in.next()+in.nextLine();
		System.out.println("enter account number");
		String accountNumber=in.next();
		System.out.println("enter amount to be  debited");
		int amount=in.nextInt();
		boolean isValidAccountNumber=((TransactionServiceImpl) ts).isValidAccountNumber(accountNumber);
		 
		boolean isValidAmount=((TransactionServiceImpl) ts).isValidAmount( amount);
		 if((isValidAccountNumber==true) && (isValidAmount==true)){
		 
		 
		if(transactiondao.debitUsingSlip( userName, accountNumber,amount)) 
			System.out.println("Amount withdrawn successfully");
		else
			throw new AmountLessException("Insufficient balance");
	  
	}
	  else
			throw new AccountException("Please enter valid input details");
	 	
	
	}
}

