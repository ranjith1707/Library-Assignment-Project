package controler;

import model.LibraryDatabase;
import model.*;
import java.util.Scanner;

public class ManageUserController {
	DataTransfer datatransfer=new DataTransfer();
   Scanner scanner=new Scanner(System.in);
   
	public boolean userIsThere(int userId) {
		if( !LibraryDatabase.getInstance().getUserList().isEmpty()) {
		for(User user: LibraryDatabase.getInstance().getUserList()) {
			if(userId==user.getUserId()) {
				return true;
			}
			
		}
		
	  }
		return false;
	}
	
	
	public boolean userFineIsThere(int userId){
		boolean flag=true;
		if(!LibraryDatabase.getInstance().getBookTransaction().isEmpty()) {
			for(BookTransactions transaction:LibraryDatabase.getInstance().getBookTransaction()) {
				if(userId==transaction.getUserId()) {
					if(transaction.isFined()==true&&transaction.isPaied()==false) {
						System.out.println("Fine Amount : "+transaction.getFineAmount()+"\n  BookId  : "+transaction.getBookId());
					
					}
					if(transaction.isFined()==transaction.isPaied()&&transaction.isFined()==false) {
						flag= true;	
					}else if(transaction.isFined()==transaction.isPaied()&&transaction.isFined()==true) {
						flag= true;
					}
					else {
						
						return false;
					}
					
				}
			}
			return flag;
		}
		return true;
	}
	
//	public void finePay(int userId,long bookId) {
//		System.out.print("Enter Amount : ");
//		int fine=scanner.nextInt();
//		if(!LibraryDatabase.getInstance().getBookTransaction().isEmpty()) {
//			for(BookTransactions transaction:LibraryDatabase.getInstance().getBookTransaction()) {
//				if(userId==transaction.getUserId()&&bookId==transaction.getBookId()) {
//					transaction.setFineAmount(fine);
//					if(transaction.getFineAmount()>=fine) {
//						boolean paid=true;
//						transaction.setPaied(paid);
//											}
//				}
//			}
//		}
//		
//		
//	}
}
