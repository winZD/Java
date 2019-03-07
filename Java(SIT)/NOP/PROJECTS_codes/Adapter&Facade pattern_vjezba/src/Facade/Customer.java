package Facade;

public class Customer implements CustomerAccount{

	String name;
	String pass;
	@Override
	public void assign2Account(String usName, String password) {
		this.name=usName;
		this.pass=password;
		System.out.println(usName+" "+password);
		
	}

	@Override
	public void checkCustomerData() {
		System.out.println("Provjereni podatci");
		
	}

}
