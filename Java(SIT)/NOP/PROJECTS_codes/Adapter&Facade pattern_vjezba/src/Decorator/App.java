package Decorator;

public class App {

	public static void main(String[] args) {
		
		Knight simpleK=new SimpleKnight();
		
		//simpleK.attack();
		
		Knight level1=new KnightFstLevel(simpleK);
		
		
		//level1.attack();
		
		Knight secLEve=new KnightSecLevel(level1);
		secLEve.attack();
	}

}
