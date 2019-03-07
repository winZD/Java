package facade_vjezba;

//FACADE CLASS	
public class ShapeMaker {

	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker(Shape c,Shape r, Shape s) {
		this.circle=c;
		this.rectangle=r;
		this.square=s;
	}
	
	public void drawCircle() {
		circle.draw();
		
	}
	
	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
	}
}
