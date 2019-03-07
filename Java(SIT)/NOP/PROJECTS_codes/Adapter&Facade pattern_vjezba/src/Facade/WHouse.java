package Facade;

public class WHouse implements Warehouse{

	@Override
	public void invoiceProcessing() {
		System.out.println("Invoice processing");
		
	}

	@Override
	public void findCustomerItems() {
		System.out.println("Items found");
		
	}

	@Override
	public void packingItems() {
		System.out.println("Packing...");
		
	}

	@Override
	public void dispatchment() {
		System.out.println("Dispatching...");
		
	}

}
