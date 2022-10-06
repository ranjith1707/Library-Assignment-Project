package controler;

import model.LibraryDatabase;

public class SetupController {

	public boolean isSetuped() {
		LibraryDatabase.getInstance();
		DataTransfer datacontrol=new DataTransfer();
		
 		LibraryDatabase.getInstance().insertBook(datacontrol.bookSetup());
		LibraryDatabase.getInstance().insertUserList(datacontrol.userSetup());
		LibraryDatabase.getInstance().insertBookTransaction(datacontrol.transactionSetup());
		return LibraryDatabase.getInstance().getBookList().size()>0;
	}
}
