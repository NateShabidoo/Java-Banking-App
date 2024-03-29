// This is an abstract multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Admin and User classes extending abstract bank class provide different submenus to users and the admin
// Admin has privileges to create or delete users

package abstractBank;

import java.util.Scanner;

public class Admin extends Bank{
    
    protected Admin(int ID, String fname, int pinNumber){
   	this.ID = ID;
   	this.fname = fname;
   	this.pinNumber = pinNumber;
   	}
    
    public static void pinEnter(int tempID) {
    	System.out.println("Enter PIN");
    	Scanner scan = new Scanner(System.in); 
    	try {
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
		catch (Exception e) {
	        System.out.println("Invalid PIN");
	        System.out.println("Please Enter a Valid 4 Digit PIN Number");
	        pinEnter(tempID);
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
    	System.out.println("Enter 1 to create user, 2 to delete user, 3 to update PIN, 4 to exit");
    	Scanner scan = new Scanner(System.in);
    	try {
        int p = scan.nextInt(); // this is the users selection
        boolean found=false;
        for(Bank t:Main.accounts) {
        	if(tempID == 1 && p == 1) {
       		 createUser(tempID);
       		 break;
       	 }
        	else if(tempID == 1 && p == 2) {
          		 deleteUser(tempID);
          		 break;
          	 }
        	else if(tempID == 1 && p == 3) {
         		 updatePIN(tempID);
        		 break;
         	 }
        	else if(tempID == 1 && p == 4) {
        		 Main.menu();
        		 break;
        	}
        	else {
        		System.out.println("Invalid Choice");
        		subMenu(tempID);
        	}
        	}
    	}
    	catch (Exception e) {
	        System.out.println("Invalid Choice");
	        subMenu(tempID);
	      }	
    }

    public void createUser(int tempID) {
    	System.out.println("Please enter user first name");
    	Scanner scan = new Scanner(System.in); 
        String y = scan.nextLine(); // this is user first name
        System.out.println("Please enter user last name");
    	Scanner scan2 = new Scanner(System.in); 
        String z = scan2.nextLine(); // this is user last name
        System.out.println("Please enter user  deposit");
    	Scanner scan3 = new Scanner(System.in); 
    	try {
        double x = scan3.nextDouble(); // this is user checking deposit
        int u = Main.accounts.size()+100;
        Main.accounts.add(new User(Main.accounts.size()+100, 0.00, x, y, z, 4444));
        System.out.println("New user created");
        System.out.println("User name is: "+y+" "+z);
        System.out.println("User ID is "+ u);
        System.out.println("User checking deposit is: "+ String.format("%.2f",x));
        subMenu(tempID);
    	}
    	catch (Exception e) {
    		System.out.println("Invalid Value, Restarting 'Create New User'");
    		createUser(tempID);	
    	}
    }
    
    public void deleteUser(int tempID) {
    	System.out.println("Enter User ID to delete, otherwise enter 0 to exit");
    	Scanner scan = new Scanner(System.in); 
        int p = scan.nextInt(); // this is the users selection
        boolean there= false;
        int place = 0;
        for(int i = 0; i<Main.accounts.size(); i++) {
        	if(Main.accounts.get(i).getID()==p) {
        		there=true;
        		place=i;
        		break;
        	}
        	else if(p==0) {
        		subMenu(tempID);
        	}
        	else {
        		there=false;
        	}}
        	if(!there) {
        		System.out.println("User ID not found");
        		deleteUser(tempID);
        	}

        	else {	
        		System.out.println("User ID "+Main.accounts.get(place).getID() +" removed");
        		Main.accounts.remove(place);
        		subMenu(tempID);
        	}
    }
    
    public int setPIN(int newPIN) {
    	this.pinNumber = newPIN;
    	return pinNumber;
    }
        
        public int getPIN() {
            return pinNumber;
        }
        
        public int getID() {
            return ID;
       }
    	
        public String getFname() {
            return fname;
       }
}
