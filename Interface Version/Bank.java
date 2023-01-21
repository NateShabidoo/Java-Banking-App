// This is an interface multi-class object based banking app which allows users to deposit and withdraw from checking 
// and savings and update PIN once entering the correct ID number and PIN
// Admin and User classes implementing Bank interface provide different submenus to users and the admin
// Admin has privileges to create or delete users

package bankInterface;

public interface Bank {
	
	public static void pinEnter(int tempID) {
	}
	
	public void subMenu(int tempID); 
	
	public void createUser(int tempID);
	
	public void deleteUser(int tempID);
	
	public int getPIN();
	
	public int getID();
	
	public double getChecking();
	
	public double setChecking();
	
	public int pinEnter();
	
	public void savingsMenu();
	
	public String getFname();
	
	public int setPIN();
	
	public void deleteUser();

}
