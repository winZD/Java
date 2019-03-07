package Decorator2;

public class LevelFstKnight extends LevelKnight {

	
	@Override
	public void setLevel(Knight k) {
		this.k=k;
		
	}

	@Override
	public void attack() {
		k.attack();
		System.out.println("Napad nogama");

	}

	@Override
	public void movement(int mov) {
		k.movement(mov);
		System.out.println("Movement "+ mov);

	}

	@Override
	public void strength(int str) {
		k.strength(str);
		System.out.println("Snaga "+str);

	}

	@Override
	public void goAway() {
		// TODO Auto-generated method stub

	}

}
