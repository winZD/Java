package Decorator2;

public class SimpleKnight implements Knight {

	int str=1;
	
	public SimpleKnight() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		System.out.println("NApad rukama");

	}

	@Override
	public void movement(int mov) {
		mov=2;
		System.out.println("movement"+mov);

	}

	@Override
	public void strength(int str) {
		str=2;
		System.out.println("Snaga " + str);

	}

	@Override
	public void goAway() {
		System.out.println();

	}

}
