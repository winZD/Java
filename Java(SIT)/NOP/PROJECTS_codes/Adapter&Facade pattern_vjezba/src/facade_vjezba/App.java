package facade_vjezba;

public class App {

	public static void main(String[] args) {
		
		ShapeMaker maker=new ShapeMaker(new Circle(),new Rectangle(), new Square());
		
		maker.drawCircle();
		maker.drawRectangle();
		maker.drawSquare();
	}

}
