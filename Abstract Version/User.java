// This is an abstract multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Admin and User classes extending abstract bank class provide different submenus to users and the admin
// Admin has privileges to create or delete users

package abstractBank;

import java.util.Scanner;

public class User extends Bank {
	
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

	protected User(int ID, double savingsBalance, double checkingBalance, String fname, String lname, int pinNumber){
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
	
	public static void pinEnter(int tempID) {
		System.out.println("Enter PIN");
		Scanner scan = new Scanner(System.in); 
	    int y = scan.nextInt(); // this is pin they enter
	    boolean found=false;
	    int z = tempID;
	    for(Bank t:Main.accounts) {
	    	 if(y == t.getPIN() && z == t.getID()) {
	    		 System.out.println("Correct PIN");
	    		 t.subMenu(tempID);
	    		 break;
	    	 }
	    	 else if(y != t.getPIN() && z == t.getID()) {
	    		 System.out.println("Incorrect PIN");
	    		 pinEnter(tempID);
	    		 break;
	    }
	    }
	}
	
	public void updatePIN(int tempID) {
		boolean found=false;
		int z = tempID;
	    for(Bank t:Main.accounts) {
	    	if(z == t.getID()) {
	    		System.out.println("Please enter new 4 digit PIN");
	        	Scanner scan = new Scanner(System.in); 
	            int y = scan.nextInt(); // this is new pin they enter
	            	System.out.println("Your PIN has been updated to "+y);
	            	setPIN(y);
	            	t.subMenu(tempID);
	            	break;
	    	}
	    	}
		}

	public void subMenu(int tempID) {
		System.out.println("Enter 1 for checking, 2 for savings, 3 to update PIN, 4 to exit");
		Scanner scan = new Scanner(System.in); 
	    int p = scan.nextInt(); // this is the users selection
	    boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(p == 1) {
	   		 checkingMenu(tempID);
	   		 break;
	   	 	}
	    	else if(p == 2) {
	      		 savingsMenu(tempID);
	      		 break;
	      	}
	    	else if(p == 3) {
	     		 updatePIN(tempID);
	     		 break;
	     	}
	    	else if(p == 4) {
	    		 Main.menu();
	    		 break;
	    	}
	    	}
		}

	public void checkingMenu(int tempID) {
		System.out.println("Enter 1 for checking balance, 2 to withdraw from checking, 3 to deposit to checking, 4 for main menu");
		Scanner scan = new Scanner(System.in); 
	    int p = scan.nextInt(); // this is the users selection
	    boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID() && p == 1) {
	      		 checkChecking(tempID);
	      		 break;
	      	 }
	    	else if(tempID == t.getID() && p == 2) {
	    		 withdrawChecking(tempID);
	    		 break;
	    	 }
	    	else if(tempID == t.getID() && p == 3) {
	    		 depositChecking(tempID);
	    		 break;
	    	 }
	    	else if(tempID == t.getID() && p == 4) {
	    		 subMenu(tempID);
	    		 break;
	    	 }
	    	}
		}

	public void withdrawChecking(int tempID) {
		boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID()) {
	    		System.out.println("How much would you like to withdraw from checking?");
	        	Scanner scan = new Scanner(System.in); 
	            double y = scan.nextDouble(); // this is withdraw amount they enter
	            if(y <= t.getChecking()) {
	            	double temp = t.getChecking() - y;
	            	System.out.println("Please take your cash");
	            	System.out.println("Your new checking balance is: "+ String.format("%.2f",temp));
	            	setChecking(temp);
	            	checkingMenu(tempID);
	            	break;
	            }
	            else if(y> t.getChecking()) {
	            	System.out.println("Amount to withdraw is greater than balance");
	            	withdrawChecking(tempID);
	            }
	    		}
	    		}
			}

	public void depositChecking(int tempID) {
		boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID()) {
	    		System.out.println("How much would you like to deposit to checking?");
	        	Scanner scan = new Scanner(System.in); 
	            double y = scan.nextDouble(); // this is deposit amount they enter
	            	double temp = t.getChecking() + y;
	            	System.out.println("Please deposit in envelope provided");
	            	System.out.println("Your new checking balance is: "+ String.format("%.2f",temp));
	            	setChecking(temp);
	            	checkingMenu(tempID);
	            	break;
	    	}
	    	}
		}

	public void checkChecking(int tempID) {
		boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID()) {
	   		 System.out.println("Your checking balance is $"+t.getChecking());
	   		 checkingMenu(tempID);
	   		 break;
	   	 	}	
	    	}
		}

	public void savingsMenu(int tempID) {
		System.out.println("Enter 1 for savings balance, 2 to withdraw from savings, 3 to deposit to savings, 4 for main menu");
		Scanner scan = new Scanner(System.in); 
	    int p = scan.nextInt(); // this is the users selection
	    boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID() && p == 1) {
	      		 checkSavings(tempID);
	      		 break;
	      	 }
	    	else if(tempID == t.getID() && p == 2) {
	    		 withdrawSavings(tempID);
	    		 break;
	    	 }
	    	else if(tempID == t.getID() && p == 3) {
	    		 depositSavings(tempID);
	    		 break;
	    	 }
	    	else if(tempID == t.getID() && p == 4) {
	    		 subMenu(tempID);
	    		 break;
	    	}
	    	}
		}

	private void checkSavings(int tempID) {
		boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID()) {
	   		 System.out.println("Your savings balance is $"+getSavings());
	   		 savingsMenu(tempID);
	   		 break;
	   	 	}	
	    }
		}

	public void withdrawSavings(int tempID) {
		boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID()) {
	    		System.out.println("How much would you like to withdraw from savings?");
	        	Scanner scan = new Scanner(System.in); 
	            double y = scan.nextDouble(); // this is withdraw amount they enter
	            if(y <= getSavings()) {
	            	double temp = getSavings() - y;
	            	temp = Math.round(temp * 100);
	            	temp = temp/100;
	            	System.out.println("Please take your cash");
	            	System.out.println("Your new savings balance is: "+ String.format("%.2f",temp));
	            	setSavings(temp);
	            	savingsMenu(tempID);
	            	break;
	            }
	            else if(y> getSavings()) {
	            	System.out.println("Amount to withdraw is greater than balance");
	            	withdrawSavings(tempID);
	            }
	    		}
	    		}
		}

	public void depositSavings(int tempID) {
		boolean found=false;
	    for(Bank t:Main.accounts) {
	    	if(tempID == t.getID()) {
	    		System.out.println("How much would you like to deposit to savings?");
	        	Scanner scan = new Scanner(System.in); 
	            double y = scan.nextDouble(); // this is deposit amount they enter
	            	double temp = getSavings() + y;
	            	System.out.println("Please deposit in envelope provided");
	            	System.out.println("Your new savings balance is: "+ String.format("%.2f",temp));
	            	setSavings(temp);
	            	savingsMenu(tempID);
	            	break;
	    		}
	    		}
		}

	public int setPIN(int newPIN) {
		this.pinNumber = newPIN;
		return pinNumber;
	}

	public double setChecking(double amount) {
		this.checkingBalance = amount;
		return checkingBalance;
	}

	public double getChecking() {
		return checkingBalance;
	}

	public int getPIN() {
	    return pinNumber;
	}
	 
	 public String getFname() {
			return fname;
		}
	 
	public int getID() {
	     return ID;
	}

	public double getSavings() {
		return savingsBalance;
	}

	public double setSavings(double amount) {
		this.savingsBalance = amount;
		return savingsBalance;
	}
}
