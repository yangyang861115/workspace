package cs61b.src.mid1spring2005;

public class A {
	public A(){
		System.out.println("New A");
	}
	
	public A(int x){}
	
	public void method1(){
		System.out.println("M1 in A");
	}
	
	public void method2(){
		System.out.println("M2 in " + whichClass());
	}
	
	public String whichClass(){
		return "A";
	}
}
