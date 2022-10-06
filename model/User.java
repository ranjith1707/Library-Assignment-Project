package model;

public class User {
	private int userId;
	private String userName;
	private long phoneNo;
	private String emailId;
	private String address;
	private boolean hasMembership;

	public User(int userId, String username, long mobileNumber, String mailId, String address, boolean membership) {
		this.userId=userId;
		this.userName=username;
		this.phoneNo=mobileNumber;
		this.emailId=mailId;
		this.address=address;
		this.hasMembership=membership;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isHasMembership() {
		return hasMembership;
	}

	public void setHasMembership(boolean hasMembership) {
		this.hasMembership = hasMembership;
	}

}
