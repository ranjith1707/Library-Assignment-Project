package view;
import java.util.Scanner;

import controler.DataTransfer;
import model.BookTransactions;
import model.LibraryDatabase;
import model.User;
public class ManageUsers {
	DataTransfer datatransfer=new DataTransfer();
	Scanner scanner=new Scanner(System.in);
	
   public void userManagement() {
	   System.out.println(" 1 > Add New User \n 2 > View User Details \n 3 > Fine Pay\n ");
	   int option=scanner.nextInt();
	   switch(option) {
	   case 1 :addNewUser();
	   break;
	   case 2 :getUserDetails();
	   break;
	   case 3 :finePay();
	   break;
	   }
   }
   
	private void addNewUser() {
	   System.out.print("Create New User Id : ");
	   int userId=scanner.nextInt();
	   scanner.nextLine();
	   System.out.print("Enter user Name : ");
	   String username=scanner.nextLine();
	   System.out.print("Enter User Mobile Number : ");
	   long mobileNumber=scanner.nextLong();
	   scanner.nextLine();
	   System.out.print("Enter User mail Id");
	   String mailId=scanner.nextLine();
	   System.out.print("Enter Addres : ");
	   String address=scanner.nextLine();
	   boolean membership;
	   System.out.print(" You Want Join the Member Ship  ?\n 1 > Yes\n 2 > No ");
	   byte option=scanner.nextByte();
		   if(option==1) {
			   membership=true;
		   }
		   else
			   membership=false;
	  User user=new User(userId,username,mobileNumber,mailId,address,membership);
	  datatransfer.addUser(userId,username,mobileNumber,mailId,address,membership);
	  LibraryDatabase.getInstance().insertUserList(user); 

	   
   }
	
	private void getUserDetails() {
		System.out.print("Enter User Id  : ");
		int userId=scanner.nextInt();
		for(User user:LibraryDatabase.getInstance().getUserList()) {
			if(user.getUserId()==userId) {
			        System.out.println("User Name     : "+user.getUserName());
			        System.out.println("User Id       : "+user.getUserId());
			        System.out.println("Mobile Number : "+user.getPhoneNo());
			        System.out.println("Mail ID       : "+user.getEmailId());
			        String member;
				        if(user.isHasMembership())
				        	member="Is A Member ";
				        else
				        	member="Not A Member";
				        System.out.println("Memeber Ship  : "+member);
			}
		}
	}
	
	private void finePay() {
		System.out.println("Enter Use Id : ");
		int userId=scanner.nextInt();
		System.out.print("Enter Book Id : ");
		long bookId=scanner.nextLong();
		if(!LibraryDatabase.getInstance().getBookList().isEmpty()) {
		  for(BookTransactions bookdetails: LibraryDatabase.getInstance().getBookTransaction()) {
			 if(bookdetails.getBookId()==bookId &&bookdetails.getUserId()==userId) {
				 scanner.nextLine();
				 System.out.print("Enter Fine Paid Date : ");
					String finePaidDate=scanner.nextLine();
					System.out.print("Is Baid or Not ! \n 1 > yes\n 2 > No ");
					int fineselection=scanner.nextInt();
					boolean isPaid;	
					if(fineselection==1) {
							isPaid=true;
						}
						else {
							isPaid=false;
						}
					
					bookdetails.setPaied(isPaid);
					bookdetails.setFinePaidDate(finePaidDate);
					datatransfer.payFine(userId, bookId,isPaid,finePaidDate);
			 }
		 }
		  
		 
		}
	}
	
}
