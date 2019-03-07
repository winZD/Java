package Decorator;

public class KnightFstLevel implements Knight {
Knight k;
	public KnightFstLevel(Knight k) {
		this.k=k;
	}
	
	@Override
	public void attack() {
		k.attack();
		System.out.println("NApad nogama");

	}

	@Override
	public void movement(int mov) {
		k.movement(mov);
		System.out.println("BRzi pkret");

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
