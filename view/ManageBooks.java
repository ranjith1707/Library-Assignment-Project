package view;
import java.util.Scanner;

import controler.DataTransfer;
import model.Book;
import model.LibraryDatabase;
public class ManageBooks {
	Scanner scanner=new Scanner(System.in);
	DataTransfer datatransfer=new  DataTransfer();
	public void bookManager() {
		System.out.println(" 1 > Add New Book \n 2 > Remove Book\n 3 > Search Book \n 4 > List All Books ");
		int selection=scanner.nextInt();
		switch(selection) {
		case 1:addNewBook();
		break;
		case 2 : removeBook();
		break;
		case 3 : searchBooks();
		break;
		case 4 :listAllBooks();
		}
	}
	private void addNewBook() {
		System.out.print("Enter Boook Id");
		long id=scanner.nextLong();
		System.out.print("Enter Title : ");
		scanner.nextLine();
		String title=scanner.nextLine();
		System.out.print("Enter Author Name : ");
		String author=scanner.nextLine();
		System.out.print("Enter Publication : ");
		String publication=scanner.nextLine();
		System.out.print("Enter Edition : ");
		String edition=scanner.nextLine();
		System.out.print("Enter Journer : ");
		String journer=scanner.nextLine();
		System.out.print("Enter Volume : ");
		int volume=scanner.nextInt();
		boolean availablity;
		if(volume>0) {
			availablity=true;
		}
		else
			availablity=false;
		Book book=new Book(id,title,author,publication,edition,journer,volume,availablity);
		datatransfer.addBook(id,title,author,publication,edition,journer,volume,availablity);
		LibraryDatabase.getInstance().insertBook(book);
	}
	private void removeBook() {
		System.out.print("Enter Book Id : ");
		long bookId=scanner.nextLong();
		if(!LibraryDatabase.getInstance().getBookList().isEmpty()) {
			for(int i=0; i<LibraryDatabase.getInstance().getBookList().size();i++) {
				if(LibraryDatabase.getInstance().getBookList().get(i).getId()==bookId) {
					datatransfer.removeBook(bookId); 
				}
			}

		}
	}

	private void listAllBooks() {

		if(!LibraryDatabase.getInstance().getBookList().isEmpty()) {
			for(Book book: LibraryDatabase.getInstance().getBookList()) {

				String available="Not Available";
				if(book.isAvailablity()) {
					available="Is Available ";
				}
				System.out.println("Publication : "+book.getPublication()+" ;  Author : "+book.getAuthor()+ " ;  Title : "+book.getTitle()+" ; Journer : "+book.getJourner()
				+" ;  Edition : "+book.getEdition()+" ; Book Id : "+book.getId()+" ; Availablity : "+available);

			}
		}
		else {
			System.out.println("Books   Not  Available ! ");
		}

	}
	private void searchBooks() {
		System.out.println(" 1 > Search By Author \n 2 > Search By Title  \n 3 > Publication \n 4 > Search By journer \n");
		int search=scanner.nextInt();
		switch(search) {
		case 1 :authorSearch(); 
		break;
		case 2 : titleSearch();
		break; 
		case 3 :publicationSearch(); 
		break;
		case 4 : journer();
		break;

		}
	}


	private void authorSearch() {
		System.out.print("Enter Authour Name : ");
		scanner.nextLine();
		String author=scanner.nextLine();
		for(Book book: LibraryDatabase.getInstance().getBookList()) {
			if(book.getAuthor().equals(author)) {
				String available="Not Available";
				if(book.isAvailablity()) {
					available="Is Available ";
				}
				System.out.println(" Author : "+book.getAuthor()+"Publication : "+book.getPublication()+ " Title : "+book.getTitle()+"Journer : "+book.getJourner()
				+" Edition : "+book.getEdition()+" Book Id : "+book.getId()+" Availablity : "+available);
			}
		}

	}
	private void titleSearch() {
		scanner.nextLine();
		System.out.print("Enter Title : ");
		String title=scanner.nextLine();
		for(Book book: LibraryDatabase.getInstance().getBookList()) {
			if(book.getTitle().equals(title)) {
				String available="Not Available";
				if(book.isAvailablity()) {
					available="Is Available ";
				}
				System.out.println( " Title : "+book.getTitle()+" Author : "+book.getAuthor()+"Publication : "+book.getPublication()+"Journer : "+book.getJourner()
				+" Edition : "+book.getEdition()+" Book Id : "+book.getId()+" Availablity : "+available);
			}
		}

	}
	private void publicationSearch() {
		scanner.nextLine();
		System.out.print("Enter Publication : ");
		String publication=scanner.nextLine();
		for(Book book: LibraryDatabase.getInstance().getBookList()) { 
			if(book.getPublication().equals(publication)) {
				String available="Not Available";
				if(book.isAvailablity()) {
					available="Is Available ";
				}
				System.out.println("Publication : "+book.getPublication()+" Author : "+book.getAuthor()+ " Title : "+book.getTitle()+"Journer : "+book.getJourner()
				+" Edition : "+book.getEdition()+" Book Id : "+book.getId()+" Availablity : "+available);
			}
		}

	}
	private void journer() {
		scanner.nextLine();
		System.out.print("Enter Journer : ");
		String journer=scanner.nextLine();
		for(Book book: LibraryDatabase.getInstance().getBookList()) {
			if(book.getJourner().equals(journer)) {
				String available="Not Available";
				if(book.isAvailablity()) {
					available="Is Available ";
				}
				System.out.println("Journer : "+book.getJourner()+" Author : "+book.getAuthor()+"Publication : "+book.getPublication()+ " Title : "+book.getTitle()
				+" Edition : "+book.getEdition()+" Book Id : "+book.getId()+" Availablity : "+available);
			}
		}

	}
}