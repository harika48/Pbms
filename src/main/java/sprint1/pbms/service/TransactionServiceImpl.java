
package sprint1.pbms.service;



import sprint1.pbms.dao.TransactionDao;
import sprint1.pbms.dao.TransactionDaoImpl;
 
 

public class TransactionServiceImpl implements TransactionService {
	 
	TransactionDao transactiondao=new TransactionDaoImpl();

	public boolean creditUsingSlip(String userName, String accountNumber,int amount) {
		// TODO Auto-generated method stub
		return transactiondao.creditUsingSlip(userName,accountNumber,amount);
	}

	public boolean debitUsingSlip(String userName, String accountNumber,int amount) {
		// TODO Auto-generated method stub
		return transactiondao.debitUsingSlip(userName, accountNumber,amount);
	}
	public void addSomeAccountDetails() {
		 transactiondao.addSomeAccountDetails();
		
	}
	public static boolean isValidAccountNumber(String accountNumber){
		boolean flag;
		 if(accountNumber.matches("[0-9]{12}")){
			 
				return true;
		}
		 System.out.println("Invalid account Number");
		 return false;
	}
	
		 public static boolean isValidAmount(int amount){
			   
				String str=String.valueOf(amount);
				if(str.matches("[1-9]{1}[0-9]*")){
					 
					return true;
				}
				 System.out.println("Invalid amount");
				return false; 
			}

//			public boolean isValid( Amount c){
//				 
//				if(isValidAccountNumber(c.getAccountNumber())&&isValidAmount(c.getAmount())){
//					return true;
//				}
//		 
//		 		return false;
//			}

			public double getBalanceByID(String accountNumber) {
				// TODO Auto-generated method stub
				return transactiondao.getBalanceById(accountNumber) ;
			}

			public boolean addAmount(String accountNumber, int amount) {
				// TODO Auto-generated method stub
				return transactiondao.addAmount(accountNumber, amount);
			}

			public boolean deductAmount(String accountNumber, int amount) {
				// TODO Auto-generated method stub
				return transactiondao.deductAmount(accountNumber, amount);
			}

			 

}
