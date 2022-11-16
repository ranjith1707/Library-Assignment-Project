package view;
import view.*;
import java.util.Scanner;
public class DashBoard {
	Scanner scanner=new Scanner(System.in);
	void mainView() {
		ManageBooks bookmanage=new ManageBooks();
		ManageUsers userManage=new ManageUsers();
		ManageTransaction transaction=new ManageTransaction();
		System.out.println(" 1 > Book Management \n 2 > User ManageMent\n 3 > Book Transaction \n ");
		int selection=scanner.nextInt();
		switch(selection) {
		case 1:bookmanage.bookManager();
		break;
		case 2 : userManage.userManagement();
		break;
		case 3 :transaction.bookTransaction();
		break;
		}
		if(selection<=3) {
			mainView();
		}
	}
}
