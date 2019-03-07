package Facade;

public class Facade {

	CustomerAccount cA;
	Payment pay;
	Shipping ship;
	Warehouse ware;
	
	String name;
	String pass;
	
	public Facade(CustomerAccount cA,Payment pay,Shipping ship,Warehouse ware) {
		this.cA=cA;
		this.pay=pay;
		this.ship=ship;
		this.ware=ware;
	}
	
	public void logIn() {
		
		cA.assign2Account("Ivan", "0812");
		pay.assign2PaymentAccount("fxzx", "456987");
	}
	
	public void payment() {
		pay.checkCustomerData();
		pay.linkToCustomerBAnkAccount();
	}
	
	public void delivery() {
		ware.dispatchment();
		ware.findCustomerItems();
		
		ship.airTransportation();
		ship.seaTransportation();
		
	}
	
	public void confirm() {
		ship.deliveryNotification();
		payment();
	}
	
	
	
}
