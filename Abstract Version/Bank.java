package abstractBank;

abstract class Bank {
	
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
