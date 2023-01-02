package bank2;

// This is a multi-class object based banking app which allows users to deposit and 
// withdraw from checking and savings once entering the correct ID number and PIN
// Polymorphism is used to provide different menus for users and the admin
// The admin has privileges to create or delete users

import java.util.Scanner;
import java.util.ArrayList;

public class Trial {
    
    private double savingsBalance;
    private double checkingBalance;
    private int ID;
    private String fname;
    private String lname;
    private int userID;
    private String userFname;
    private String userLname;
    private int pinNumber;
    private int tempID;
    private ArrayList<Trial> accounts2;
   
public Trial(int ID, double savingsBalance, double checkingBalance, String fname, String lname, int pinNumber){
   if (savingsBalance > 0.0) {
   this.savingsBalance = savingsBalance;
   }
   if (checkingBalance > 0.0) {
   this.checkingBalance = checkingBalance;
   }
   this.ID = ID;
   this.fname = fname;
   this.lname = lname;
   this.pinNumber = pinNumber;
}

public Trial(int ID, String fname, int pinNumber){
	   this.ID = ID;
	   this.fname = fname;
	   this.pinNumber = pinNumber;
	}

public void pinEnter(int tempID) {
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
	System.out.println("Enter 1 for checking, 2 for savings, 3 to update PIN, 4 to exit");
	Scanner scan = new Scanner(System.in); 
    int p = scan.nextInt(); // this is the users selection
    boolean found=false;
    for(Trial t:Bank.accounts) {
    	if(p == 1) {
   		 Bank.checkingMenu(tempID);
   		 break;
   	 	}
    	else if(p == 2) {
      		 Bank.savingsMenu(tempID);
      		 break;
      	}
    	else if(p == 3) {
     		 Bank.updatePIN(tempID);
     		 break;
     	}
    	else if(p == 4) {
    		 Bank.menu();
    		 break;
    	}
    	}
	}

public ArrayList<Trial> getList() {
    return accounts2;
}

public int getID() {
      return ID;
}

public String getFname() {
    return fname;
}

public String setFname(String name) {
    this.fname = name;
	return fname;
}

public int getPIN() {
    return pinNumber;
}

public double getChecking() {
	return checkingBalance;
}

public double setChecking(double amount) {
	this.checkingBalance = amount;
	return checkingBalance;
}

public int setPIN(int newPIN) {
	this.pinNumber = newPIN;
	return pinNumber;
}

public double setSavings(double amount) {
	this.savingsBalance = amount;
	return savingsBalance;
}

public double getSavings() {
	return savingsBalance;
}
}
