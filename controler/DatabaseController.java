package controler;

import java.sql.*;
public class DatabaseController {
	
	
public Statement getStatement()  {
	Statement statement=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Ranjithkumar@1705");
		statement=connect.createStatement();
		
		return statement;
	} catch (Exception e) {
		
	}
	return statement;
}


}
