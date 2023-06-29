// This is a multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Dynamic polymorphism is used to provide different menus to users and the admin
// Admin has privileges to create or delete users

package bank5;

import java.util.Scanner;
import java.util.ArrayList;

public class Trial {
    private double savingsBalance;
    private double checkingBalance;
    private int ID;
    private String fname;
    private String lname;
    private int pinNumber;
    private int tempID;
    private ArrayList<Trial> accounts2;
   
protected Trial(int ID, double savingsBalance, double checkingBalance, String fname, String lname, int pinNumber){
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

protected Trial(int ID, String fname, int pinNumber){
	   this.ID = ID;
	   this.fname = fname;
	   this.pinNumber = pinNumber;
	}

protected void pinEnter(int tempID) {
    System.out.println("Enter 4 Digit PIN");
    Scanner scan = new Scanner(System.in); 
    try {
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
	} catch (Exception e) {
		System.out.println("Invalid Entry");
		pinEnter(tempID);
	}
}

protected void subMenu(int tempID) {
    System.out.println("Enter 1 for checking, 2 for savings, 3 to update PIN, 4 to exit");
    Scanner scan = new Scanner(System.in); 
    try {
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
	} catch (Exception e) {
		System.out.println("Invalid Entry");
		subMenu(tempID);
	}
	}

protected ArrayList<Trial> getList() {
    return accounts2;
}

protected int getID() {
      return ID;
}

protected String getFname() {
    return fname;
}

protected String setFname(String name) {
    this.fname = name;
	return fname;
}

protected int getPIN() {
    return pinNumber;
}

protected double getChecking() {
	return checkingBalance;
}

protected double setChecking(double amount) {
	this.checkingBalance = amount;
	return checkingBalance;
}

protected int setPIN(int newPIN) {
	this.pinNumber = newPIN;
	return pinNumber;
}

protected double setSavings(double amount) {
	this.savingsBalance = amount;
	return savingsBalance;
}

protected double getSavings() {
	return savingsBalance;
}
}

