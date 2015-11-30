package cs61b.src.lab5;

public class X {
	public int number;
	public static final int AGE = 100; 
	public X(int i){
		this.number = i;
	}
	public void say(int i){
		System.out.println("I am x.");
		//return number;
	}
	
	public int sayHello(){
		System.out.println("hello, I am x.");
		return number;
	}
}
