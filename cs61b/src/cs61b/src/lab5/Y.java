package cs61b.src.lab5;

public class Y extends X implements Z{
	String name;
	public Y(int i) {
		super(i);
		name = "I an y";
	}
	public void say(String s){
		System.out.println("I am y.");
	};
	
	public int sayHello(){
		System.out.println("hello, I am y.");
		return 50;
	}
	/*public static void main(String args[]){
		Y y = new Y(2);
		System.out.println(((Z)y).AGE);
		System.out.println(((X)y).AGE);
	}
	*/
}
