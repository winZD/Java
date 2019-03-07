package Decorator;

public class KnightSecLevel implements Knight {

	Knight k;
	
	public KnightSecLevel(Knight k) {
		this.k=k;
	}
	
	@Override
	public void attack() {
		k.attack();
		System.out.println("NApad glavom");

	}

	@Override
	public void movement(int mov) {
		// TODO Auto-generated method stub

	}

	@Override
	public void strength(int str) {
		// TODO Auto-generated method stub

	}

	@Override
	public void goAway() {
		// TODO Auto-generated method stub

	}

}
