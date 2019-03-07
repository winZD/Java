package Facade;

public class Ship implements Shipping{

	@Override
	public void roadTransportation() {
	System.out.println("Road transport");
		
	}

	@Override
	public void seaTransportation() {
		System.out.println("Sea transport");
		
	}

	@Override
	public void airTransportation() {
		System.out.println("Air transport");
		
	}

	@Override
	public void deliveryNotification() {
		System.out.println("Delivered....");
		
	}

}
