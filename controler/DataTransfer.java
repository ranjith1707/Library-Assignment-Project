package controler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BookTransactions;
import model.User;

public class DataTransfer {

	List<Book> tempDatabase=new ArrayList<Book>();
	List<User>tempUserData=new ArrayList<User>();
	List<BookTransactions> tempTransaction=new ArrayList<BookTransactions>();
	DatabaseController datacontrol=new DatabaseController(); 

	public List<Book> bookSetup() {
		Statement statement=datacontrol.getStatement();
		try {
			ResultSet addBook=statement.executeQuery("select * from books");
			while(addBook.next()) {
				Book book=new Book(addBook.getLong(1),addBook.getString(2),addBook.getString(3),addBook.getString(4),addBook.getString(5),
						addBook.getString(6),addBook.getInt(7),addBook.getBoolean(8));
				tempDatabase.add(book);
			}


		} catch (SQLException e) {

		}
		return tempDatabase;
	}

	public List<User> userSetup(){
		Statement statement=datacontrol.getStatement();
		try {
			ResultSet userData=statement.executeQuery("select * from user");
			while(userData.next()) {
				User user=new User(userData.getInt(1),userData.getString(2), userData.getLong(3),
						userData.getString(4),userData.getString(5),userData.getBoolean(6));
				tempUserData.add(user);
			}


		} catch (SQLException e) {

		}
		return tempUserData;
	}

	public List<BookTransactions> transactionSetup() {
		Statement statement=datacontrol.getStatement();
		try {
			ResultSet transferData=statement.executeQuery("select * from booktransaction");
			while(transferData.next()) {
				BookTransactions transaction=new BookTransactions(transferData.getLong(1),transferData.getInt(2), transferData.getString(3),
						transferData.getString(4),transferData.getString(5),transferData.getBoolean(6),transferData.getInt(7),transferData.getBoolean(8),transferData.getString(9),transferData.getString(10),transferData.getString(11));
				tempTransaction.add(transaction);

			}


		} catch (SQLException e) {

		}
		return tempTransaction;
	}


	public void addUser(int userId,String username,Long mobileNumber,String mailId,String address,boolean membership){
		Statement statement=datacontrol.getStatement();
		try {
			int insertUserData=statement.executeUpdate("insert into user(userId,username,phoneNo,mailId,address,memberShip)values("+userId+",'"+username+"',"+mobileNumber+",'"+mailId+"','"+address+"',"+membership+")");
			System.out.println("Update Successful  ! ");
		} catch (SQLException e) {
			System.out.println("User Name Not Updated ! ");
		}

	}
	public void addBook(long id,String title,String author,String publication,String edition,String journer,int volume,boolean availablity){
		Statement statement=datacontrol.getStatement();
		try {
			int insertBookData=statement.executeUpdate("insert into books(Id,Title,Authour,Publication,Edition,journer,Volume,Availablity)values("+id+",'"+title+"','"+author+"','"+publication+"','"+edition+"','"+journer+"',"+volume+","+availablity+")");

		} catch (SQLException e) {
			System.out.println(" Book Not Updated ! ");
		}

	}
	public void removeBook(long bookId) {
		Statement statement=datacontrol.getStatement();
		try {
			int removeBookData=statement.executeUpdate("delete from books where Id="+bookId+"");
			System.out.println("Book Removed  ");
		} catch (SQLException e) {
			System.out.println(" Book Not Removed ! ");
		}
	}

	public void payFine(int userId,long bookId,boolean isPaid,String finePaidDate) {
		Statement statement=datacontrol.getStatement();
		try {
			String payment=" update booktransaction Set IsPaid="+isPaid+",FinePaidDate='"+finePaidDate+"' where BookId="+bookId+" And UserId="+userId+";";
			int fine=statement.executeUpdate(payment);
		}catch(Exception e) {
			System.out.println("Not Payd  ! ");
			e.printStackTrace();
		}
	}

	public void bookTransaction(long bookId,int userId,String dateBorrowed,String dateToBeReturn,String returnedDate,boolean isFined,int fineAmount,boolean isPaied,String finedDate,
			String fineDueDate,String finePaidDate) {
		Statement statement=datacontrol.getStatement();
		try {
			int tBookData=statement.executeUpdate("insert into booktransaction(BookId,UserId,DateOfBorrowed,ReturningDate,returnedDate,IsFine,FineAmount,IsPaid,FinedDate,FineDueDate,FinePaidDate)values("
					+ ""+bookId+","+userId+",'"+dateBorrowed+"','"+dateToBeReturn+"','"+returnedDate+"',"+isFined+","+fineAmount+","+isPaied+",'"+finedDate+"','"+fineDueDate+"','"+finePaidDate+"')");
			System.out.println(" Take the  Book ");
		} catch (SQLException e) {
			System.out.println(" book no transferd ! ");
		}
	}

	public  void  bookReturn(String returnedDate,boolean isFine,int fineAmount,boolean isPaid,String finedDate,String dueDate,String finePaidDate, int userId,long bookId) {
		Statement statement=datacontrol.getStatement();
		try {
			String query= "update booktransaction set returnedDate='"+returnedDate+"',IsFine="+isFine+",IsPaid="+isPaid+",FineAmount="+fineAmount+",FinedDate='"+finedDate+"',FineDueDate='"+dueDate+"',FinePaidDate='"+finePaidDate+"' where UserId="+userId+" AND BookId="+bookId+"";
			int returnCount=statement.executeUpdate(query);

		}catch(Exception e) {
			System.out.println("Exception ");
			e.printStackTrace();
		}
	}
	public void bookReturn(String returnedDate, int userId,long bookId) {
		Statement statement=datacontrol.getStatement();
		try {
			int update=statement.executeUpdate(" update  booktransaction set returnedDate='"+returnedDate+"' where UserId="+userId+" and BookId="+bookId+"");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
