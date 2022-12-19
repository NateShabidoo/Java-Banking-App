package bank2;

//This is a multi-class object based banking app which allows users to deposit and withdraw from checking 
//and savings once entering the correct ID number and PIN

import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
   
    private static ArrayList<Trial> accounts = new ArrayList();

    public static void main(String[] args) {
        init();
        menu();
        
    }
    
    private static void init(){
        accounts.add(new Trial(100, 20.03, 100.00, "Adam", "Driver", 1234));
        accounts.add(new Trial(102, 440.03, 100.00, "Michael", "Jordan", 1111));
        accounts.add(new Trial(103, 442.03, 101.00, "Jeff", "Bezos", 1111));
      
     }
    
    private static void pinEnter(int tempID) {
    	System.out.println("Enter PIN");
    	Scanner scan = new Scanner(System.in); 
        int y = scan.nextInt(); // this is pin they enter
        
        boolean found=false;
        for(Trial t:accounts) {
        	 if(tempID == t.getID() && y == t.getPIN()) {
        		 System.out.println("Correct PIN");
        		 subMenu(tempID);
        		 break;
        	 }
        	 else if(tempID == t.getID() && y != t.getPIN()){
        		 System.out.println("Incorrect PIN");
        		 pinEnter(tempID);
        	 }
        }
    }
    
    private static void createUser() {
    	System.out.println("Please enter user first name");
    	Scanner scan = new Scanner(System.in); 
        String y = scan.nextLine(); // this is user first name
        System.out.println("Please enter user last name");
    	Scanner scan2 = new Scanner(System.in); 
        String z = scan2.nextLine(); // this is user last name
        System.out.println("Please enter user savings deposit");
    	Scanner scan3 = new Scanner(System.in); 
        double x = scan3.nextDouble(); // this is user savings deposit
 
        accounts.add(new Trial(accounts.size(), 0.00, x, y, z, 4444));
    }
    
    private static void withdrawChecking(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
        		System.out.println("How much would you like to withdraw from checking?");
            	Scanner scan = new Scanner(System.in); 
                double y = scan.nextDouble(); // this is withdraw amount they enter
                if(y <= t.getChecking()) {
                	double temp = t.getChecking() - y;
                	System.out.println("Please take your cash");
                	System.out.println("Your new checking balance is: "+ String.format("%.2f",temp));
                	t.setChecking(temp);
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
    
    private static void depositChecking(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
        		System.out.println("How much would you like to deposit to checking?");
            	Scanner scan = new Scanner(System.in); 
                double y = scan.nextDouble(); // this is deposit amount they enter
                	double temp = t.getChecking() + y;
                	System.out.println("Please deposit in envelope provided");
                	System.out.println("Your new checking balance is: "+ String.format("%.2f",temp));
                	t.setChecking(temp);
                	checkingMenu(tempID);
                	break;
        	}
        	}
    	}
    
    private static void withdrawSavings(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
        		System.out.println("How much would you like to withdraw from savings?");
            	Scanner scan = new Scanner(System.in); 
                double y = scan.nextDouble(); // this is withdraw amount they enter
                if(y <= t.getSavings()) {
                	double temp = t.getSavings() - y;
                	temp = Math.round(temp * 100);
                	temp = temp/100;
                	System.out.println("Please take your cash");
                	System.out.println("Your new savings balance is: "+ String.format("%.2f",temp));
                	t.setSavings(temp);
                	savingsMenu(tempID);
                	break;
                }
                else if(y> t.getSavings()) {
                	System.out.println("Amount to withdraw is greater than balance");
                	withdrawSavings(tempID);
                }
        		}
        		}
    	}
    
    private static void depositSavings(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
        		System.out.println("How much would you like to deposit to savings?");
            	Scanner scan = new Scanner(System.in); 
                double y = scan.nextDouble(); // this is deposit amount they enter
                	double temp = t.getSavings() + y;
                	System.out.println("Please deposit in envelope provided");
                	System.out.println("Your new savings balance is: "+ String.format("%.2f",temp));
                	t.setSavings(temp);
                	savingsMenu(tempID);
                	break;
        		}
        		}
    	}
    
    
    private static void checkChecking(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
       		 System.out.println("Your checking balance is $"+t.getChecking());
       		 checkingMenu(tempID);
       		 break;
       	 	}	
        	}
    	}
    
    private static void checkSavings(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
       		 System.out.println("Your savings balance is $"+t.getSavings());
       		 savingsMenu(tempID);
       		 break;
       	 	}	
        }
    	}
    
    private static void checkingMenu(int tempID) {
    	System.out.println("Enter 1 for checking balance, 2 to withdraw from checking, 3 to deposit to checking, 4 for main menu");
    	Scanner scan = new Scanner(System.in); 
        int p = scan.nextInt(); // this is the users selection
        boolean found=false;
        for(Trial t:accounts) {
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
    
    private static void savingsMenu(int tempID) {
    	System.out.println("Enter 1 for savings balance, 2 to withdraw from savings, 3 to deposit to savings, 4 for main menu");
    	Scanner scan = new Scanner(System.in); 
        int p = scan.nextInt(); // this is the users selection
        boolean found=false;
        for(Trial t:accounts) {
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
    
    private static void updatePIN(int tempID) {
    	boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID()) {
        		System.out.println("Please enter new 4 digit PIN");
            	Scanner scan = new Scanner(System.in); 
                int y = scan.nextInt(); // this is new pin they enter
                	System.out.println("Your PIN has been updated to "+y);
                	t.setPIN(y);
                	subMenu(tempID);
                	break;
        	}
        	}
    	}
    
    private static void subMenu(int tempID) {
    	System.out.println("Enter 1 for checking, 2 for savings, 3 to update PIN, 4 to exit");
    	Scanner scan = new Scanner(System.in); 
        int p = scan.nextInt(); // this is the users selection
        boolean found=false;
        for(Trial t:accounts) {
        	if(tempID == t.getID() && p == 1) {
       		 checkingMenu(tempID);
       		 break;
       	 }
        	else if(tempID == t.getID() && p == 2) {
          		 savingsMenu(tempID);
          		 break;
          	 }
        	else if(tempID == t.getID() && p == 3) {
         		 updatePIN(tempID);
         		 break;
         	 }
        	else if(tempID == t.getID() && p == 4) {
        		 menu();
        		 break;
        	}
        	}
    	}
      
    private static void menu() {
            System.out.println("Main menu, enter user ID");
            Scanner ident =new Scanner(System.in);
            int x = ident.nextInt();
            boolean found=false;
            for(Trial t:accounts) {
                    if(x == t.getID()) {
                            System.out.println("Welcome " + t.getFname());
                            found=true;
                            int tempID = t.getID();
                            pinEnter(tempID);
                            break;   
                       } 
                    }
            
            if(!found) {
                    System.out.println("We're sorry, you are not in the system");
                    menu();
            }
            }     
}
