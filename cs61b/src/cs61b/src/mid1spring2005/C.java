package cs61b.src.mid1spring2005;

public class C extends A implements B {
	public C(){
		System.out.println("New C");
	}
	
	public C(int x){
		super(x);
	}
	
	public void method1() {
		System.out.println("M1 in C");
	}
	
	public void method3() {
		super.method1();
	}
	
	public String whichClass(){
		return "C";
	}
}
