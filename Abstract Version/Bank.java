// This is an abstract multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Admin and User classes extending abstract bank class provide different submenus to users and the admin
// Admin has privileges to create or delete users

package abstractBank;

abstract class Bank {
	
	protected double savingsBalance;
    	protected double checkingBalance;
    	protected int ID;
    	protected String fname;
    	protected String lname;
    	protected int pinNumber;
	
	public abstract void pinEnter();
	
	public abstract void subMenu(int tempID); 
	
	public abstract void createUser(int tempID);
	
	public abstract void deleteUser(int tempID);
	
	public abstract int getPIN();
	
	public abstract int getID();
	
	public abstract double getChecking();
	
	public abstract double setChecking();
	
	public abstract void savingsMenu();
	
	public abstract String getFname();
	
	public abstract int setPIN();
	
	public abstract void deleteUser();

}
