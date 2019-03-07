package Facade;

public class Pay implements Payment{

	String name;
	String pass;
	
	@Override
	public void assign2PaymentAccount(String usName, String password) {
		this.name=usName;
		this.pass=password;
		System.out.println("Assign to "+usName+" "+password);
		
	}

	@Override
	public void checkCustomerData() {
		System.out.println("Provjereni podatci");
		
	}

	@Override
	public void linkToCustomerBAnkAccount() {
		System.out.println("Ban Account: HR421851515145474418");
		
	}

	@Override
	public void performTransaction2BankAccount() {
		System.out.println("TRansaction.......");
	}

}
