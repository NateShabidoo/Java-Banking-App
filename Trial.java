package bank2;

//This is a multi-class object based banking app which allows users to deposit and withdraw from checking and savings once entering the correct ID number and PIN

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
