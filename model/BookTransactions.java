	package model;

public class BookTransactions {
	private long bookId;
	private int userId;
	private String dateBorrowed;
	private String dateToBeReturn;
	private String returnedDate;
	private boolean isFined;
	private int fineAmount;
	private boolean isPaied;
	private String finedDate;
	private String fineDueDate;
	private String finePaidDate;
	public BookTransactions(long bookId, int userId, String dateBorrowed, String dateToBeReturn,
			String returnedDate, boolean isFined, int fineAmount, boolean isPaied, String finedDate,
			String fineDueDate, String finePaidDate) {
		
		this.bookId=bookId;
		this.userId=userId;
		this.dateBorrowed=dateBorrowed;
		this.dateToBeReturn=dateToBeReturn;
		this.returnedDate=returnedDate;
		this.isFined=isFined;
		this.fineAmount=fineAmount;
		this.isPaied=isPaied;
		this.finedDate=finedDate;
		this.fineDueDate=fineDueDate;
		this.finePaidDate=finePaidDate;
		
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDateToBeReturn() {
		return dateToBeReturn;
	}
	public void setDateToBeReturn(String dateToBeReturn) {
		this.dateToBeReturn = dateToBeReturn;
	}
	public String getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public String getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}
	public boolean isFined() {
		return isFined;
	}
	public void setFined(boolean isFined) {
		this.isFined = isFined;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public boolean isPaied() {
		return isPaied;
	}
	public void setPaied(boolean isPaied) {
		this.isPaied = isPaied;
	}
	public String getFinedDate() {
		return finedDate;
	}
	public void setFinedDate(String finedDate) {
		this.finedDate = finedDate;
	}
	public String getFineDueDate() {
		return fineDueDate;
	}
	public void setFineDueDate(String fineDueDate) {
		this.fineDueDate = fineDueDate;
	}
	public String getFinePaidDate() {
		return finePaidDate;
	}
	public void setFinePaidDate(String finePaidDate) {
		this.finePaidDate = finePaidDate;
	}
}
