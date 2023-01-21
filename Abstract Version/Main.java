// This is an abstract multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Admin and User classes extending abstract bank class provide different submenus to users and the admin
// Admin has privileges to create or delete users

package abstractBank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Bank> accounts = new ArrayList();
	
	public static void main(String[] args) {
        init();
        menu();
        
    }

private static void init(){
    accounts.add(new User(100, 20.03, 100.00, "Adam", "Driver", 1234));
    accounts.add(new User(101, 440.03, 100.00, "Michael", "Jordan", 1111));
    accounts.add(new User(102, 442.03, 101.00, "Jeff", "Bezos", 1111));
    accounts.add(new Admin(1, "Admin", 1111));
 }

protected static void menu() {
    System.out.println("Main menu, enter user ID");
    Scanner ident =new Scanner(System.in);
    int x = ident.nextInt();
    boolean found=false;
    for(Bank t:accounts) {
            if(x == t.getID() && x == 1) {
                    System.out.println("Welcome " + t.getFname());
                    found=true;
                    int tempID = t.getID();
                    Admin.pinEnter(tempID);
                    break;   
               }
            else if(x == t.getID() && x != 1) {
            		System.out.println("Welcome "+ t.getFname());
            		found = true;
            		int tempID = t.getID();
            		User.pinEnter(tempID);
            		break;
            }
            }
    
    if(!found) {
            System.out.println("We're sorry, you are not in the system");
            menu();
    }
    }
}
	

