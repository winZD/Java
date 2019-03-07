package Facade;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		
		CustomerAccount c=new Customer();
		
		Payment pay=new Pay();
		
		Warehouse w=new WHouse();
		
		Shipping ship=new Ship();
		
		Facade fac=new Facade(c, pay, ship, w);
		
		fac.logIn();
		Thread.sleep(3000);
		//fac.payment();
		Thread.sleep(3000);
		fac.confirm();
		Thread.sleep(3000);
		fac.delivery();
		
	
		
		
	}

}
