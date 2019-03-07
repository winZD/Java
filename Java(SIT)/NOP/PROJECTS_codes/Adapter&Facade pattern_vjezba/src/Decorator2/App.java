package Decorator2;

public class App {

	public static void main(String[] args) {
		
		Knight simple=new SimpleKnight();
		//simple.attack();
		//simple.movement(2);
		
		LevelFstKnight first=new LevelFstKnight();
		first.setLevel(simple);
		first.movement(3);
		first.attack();
		first.strength(5);
		

	}

}
