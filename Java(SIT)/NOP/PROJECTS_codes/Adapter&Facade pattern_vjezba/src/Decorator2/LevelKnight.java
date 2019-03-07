package Decorator2;

public abstract class LevelKnight implements Knight{

	public Knight k;
	
	public void setLevel(Knight k) {
		this.k=k;
	}
	
}
