package view;
import controler.DataTransfer;
import controler.ManageUserController;
import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import model.BookTransactions;
import model.LibraryDatabase;
public class ManageTransaction {
	Date date=new Date();
	Scanner scanner=new Scanner(System.in);
	ManageUserController usercontroll=new ManageUserController();
	DataTransfer datacontrol=new DataTransfer();
	public void bookTransaction() {
		System.out.println(" 1 > Get Books \n 2 > Return Book \n ");
		int select=scanner.nextInt();
		switch(select) {
		case 1 :getBook();
		break;
		case 2 :bookReturn();
		break;
		}
		
	}
	
	private void getBook() {
	         
			System.out.print("Enter Book ID : ");
		    long bookId=scanner.nextLong();
		    System.out.print("Enter User Id : ");
			int userId=scanner.nextInt();
			scanner.nextLine();
			if(usercontroll.userIsThere(userId)&&usercontroll.userFineIsThere(userId)) {
				
			
			Locale lcl = Locale.FRENCH; 
			DateFormat dateformate=DateFormat.getDateInstance(DateFormat.SHORT,lcl);
			String dateBorrowed=dateformate.format(date);
			System.out.print("Enter Returning Date : ");
			String dateToBeReturn=scanner.nextLine();
			String returnedDate="no result";
			boolean isFined=false;
			int fineAmount=0;
			boolean isPaied=false;
			String finedDate="No result";
			String fineDueDate="No result";
			String finePaidDate="No Result";
			BookTransactions transction=new BookTransactions(bookId,userId,dateBorrowed,dateToBeReturn,returnedDate,isFined,fineAmount,isPaied,finedDate,
					fineDueDate,finePaidDate);	
			LibraryDatabase.getInstance().getBookTransaction().add(transction);
			datacontrol.bookTransaction(bookId,userId,dateBorrowed,dateToBeReturn,returnedDate,isFined,fineAmount,isPaied,finedDate,
					fineDueDate,finePaidDate);
			}
			else {
				if(!usercontroll.userFineIsThere(userId))
				               System.out.println("User Fine Is Founded ! ");
				else
					System.out.println("User Id Not Fount ! ");
			}
	}
	
	
	private void bookReturn() {
		System.out.print("Enter user Id : ");
		int userId=scanner.nextInt();
		System.out.print("Enter Book Id : ");
		long bookId=scanner.nextLong();
		scanner.nextLine();
		for(BookTransactions transaction:LibraryDatabase.getInstance().getBookTransaction()) {
			if(userId==transaction.getUserId()&&bookId==transaction.getBookId()) {
				System.out.print("Enter Returned Date : ");
				String returnedDate=scanner.nextLine();
				boolean isFine;
				int fineAmount;
				boolean isPaid;
				Locale lcl = Locale.FRENCH;
				DateFormat dateformate=DateFormat.getDateInstance(DateFormat.SHORT,lcl);
				String finedDate=dateformate.format(date);
				String dueDate="No Result Found ! ";
				String finePaidDate="Not Paid";
				System.out.println("Does this user have Any Penlites ?  /n 1 > Yes\n 2 > No");
				int option=scanner.nextInt();
					if(option==1) {
						isFine=true;
						System.out.print("Enter Fine Amount : ");
						fineAmount=scanner.nextInt();
						System.out.print("Is Baid or Not ! \n 1 > yes\n 2 > No ");
						int fineselection=scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter Due Date : ");
						dueDate=scanner.nextLine();
							if(fineselection==1) {
								isPaid=true;
								System.out.print("Enter Fine Paid Date : ");
								finePaidDate=scanner.nextLine();
							}
							else {
								isPaid=false;
							}
						
						transaction.setReturnedDate(returnedDate);
						transaction.setFined(isFine);
						transaction.setFineAmount(fineAmount);
						transaction.setPaied(isPaid);
						transaction.setFinedDate(finedDate);
						transaction.setFineDueDate(dueDate);
						transaction.setFinePaidDate(finePaidDate);
						datacontrol.bookReturn(returnedDate,isFine,fineAmount,isPaid,finedDate,dueDate,finePaidDate,userId,bookId);
						return;
					}
					else {
						isFine=false;
						transaction.setReturnedDate(returnedDate);
						datacontrol.bookReturn(returnedDate,userId,bookId);
						return; 
						
					}
			}
		}

	}
}
