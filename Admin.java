package bank2;

// This is a multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Polymorphism is used to provide different menus to users and the admin
// Admin has privileges to create or delete users

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Admin extends Trial {

	protected Admin(int ID, String fname, int pinNumber){
			super(ID, fname, pinNumber);
		}
	
	protected void createUser(int tempID) {
    	System.out.println("Please enter user first name");
    	Scanner scan = new Scanner(System.in); 
      	String y = scan.nextLine(); // this is user first name
      	System.out.println("Please enter user last name");
    	Scanner scan2 = new Scanner(System.in); 
      	String z = scan2.nextLine(); // this is user last name
      	System.out.println("Please enter user  deposit");
    	Scanner scan3 = new Scanner(System.in); 
      	double x = scan3.nextDouble(); // this is user checking deposit
      	int u = Bank.accounts.size()+100;
      	Bank.accounts.add(new Trial(Bank.accounts.size()+100, 0.00, x, y, z, 4444));
      	System.out.println("New user created");
      	System.out.println("User name is: "+y+" "+z);
      	System.out.println("User ID is: "+ u);
      	System.out.println("User checking deposit is: "+ x);
      	subMenu(tempID);
    }
	
   	protected void pinEnter(int tempID) {
    	System.out.println("Enter PIN");
    	Scanner scan = new Scanner(System.in); 
        int y = scan.nextInt(); // this is pin they enter
        boolean found=false;
        int z = tempID;
        for(Trial t:Bank.accounts) {
        	 if(y == t.getPIN() && z == t.getID()) {
        		 System.out.println("Correct PIN");
        		 t.subMenu(tempID);
        		 break;
        	 }
        	 else if(y != t.getPIN() && z == t.getID()) {
        		 System.out.println("Incorrect PIN");
        		 t.pinEnter(tempID);
        		 break;
        	 }
        }
   }
	
	protected void subMenu(int tempID) {
    	System.out.println("Enter 1 to create user, 2 to delete user, 3 to update PIN, 4 to exit");
    	Scanner scan = new Scanner(System.in); 
        int p = scan.nextInt(); // this is the users selection
        boolean found=false;
        for(Trial t:Bank.accounts) {
        	if(tempID == 1 && p == 1) {
       		 createUser(tempID);
       		 break;
       	 }
        	else if(tempID == 1 && p == 2) {
          		 deleteUser(tempID);
          		 break;
          	 }
        	else if(tempID == 1 && p == 3) {
         		 Bank.updatePIN(tempID);
        		 break;
         	 }
        	else if(tempID == 1 && p == 4) {
        		 Bank.menu();
        		 break;
        	}
        	}
	}

	protected void deleteUser(int tempID) {
	System.out.println("Enter User ID to delete, otherwise enter 0 to exit");
    	Scanner scan = new Scanner(System.in); 
        int p = scan.nextInt(); // this is the users selection
        boolean found=false;
        int z = tempID;
        for(int i = 0; i<Bank.accounts.size(); i++) {
        if(Bank.accounts.get(i).getID() == p) {
        int y = Bank.accounts.get(i).getID();
        Bank.accounts.remove(i);
        System.out.println("User ID "+y+" is now deleted");
        subMenu(tempID);
        break;
        }
        else if (p == 0) {
        	subMenu(tempID);
        	break;
        	}
        else if(Bank.accounts.get(i).getID() != p) {
        	continue;
        	}
        else  {
        	System.out.println("User ID not found");
        	deleteUser(tempID);
        	break;
        	}
        }
}
}
