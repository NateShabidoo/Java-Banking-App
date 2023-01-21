package bank10;

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
