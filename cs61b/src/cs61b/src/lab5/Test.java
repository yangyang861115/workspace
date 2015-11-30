package cs61b.src.lab5;

public class Test {

	public static void main(String[] args) {
		/*//test 0
		X x;
		Y y;
		y = new Y(2);
		x = y;
		System.out.println(x.number); // ok
		x = new X(3);
		y =(Y)x;
		System.out.println(y.name); // run-time error
		*/
		
		/*//test 1
		X xa[] = new X[2];
		Y ya[] = new Y[2];
		xa[0] = new Y(1);
		xa[1] = new Y(2);
		ya[0] = new Y(3);
		ya[1] = new Y(4);
		//xa = ya;
		//System.out.println(xa[0].number);
		ya = (Y[])xa;
		System.out.println(ya[0].number); //run-time error
		*/
		
		/*//test 2
		Y y = new Y(2);
		y.say("ss");
		*/
		
		/*//test 3
		Y y = new Y(2);
		System.out.println(y.AGE);//ambiguous
		*/
		
		/*//test 4
		Y y = new Y(2);
		y.sayHello();
		((X)y).sayHello();
		
		X x = new X(3);
		((Y)x).sayHello();
		*/
		Y y = new Y(2);
		X x;
		x = (X)y;
		x.sayHello();
	}

}
