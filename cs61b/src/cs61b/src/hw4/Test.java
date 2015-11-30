package cs61b.src.hw4;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//empty DList
		/*DList list = new DList();
		list.insertFront(2);
		list.insertFront(1);
		list.insertBack(3);
		list.insertBack(4);
		list.insertAfter(4, list.front());
		System.out.println(list.isEmpty());
		System.out.println(list.size);
		System.out.println(list);
		list.remove(list.front());
		System.out.println(list.size);
		System.out.println((list.next(list.front())).item);
		System.out.println((list.prev(list.back())).item);
		*/
		System.out.println("Testing Constructor");
		LockDList testList = new LockDList();
		System.out.println("Is empty? Should be true: " + testList.isEmpty());
		System.out.println("Should be zero length: " + testList.length());
		System.out.println("Should be [  ]: " + testList);
		System.out.println("\nTesting insertFront");
		testList.insertFront(1);
		System.out.println("Is empty? Should be false: " + testList.isEmpty());
		System.out.println("Should be one length: " + testList.length());
		System.out.println("Should be [ 1 ]: " + testList);
		System.out.println("\nTesting insertBack");
		testList.insertBack(3);
		System.out.println("Is empty? Should be false: " + testList.isEmpty());
		System.out.println("Should be two length: " + testList.length());
		System.out.println("Should be [ 1 3 ]: " + testList);
		System.out.println("\nTesting front()");
		System.out.println("This should print out 1: " + testList.front().item);
		System.out.println("\nTesting back()");
		System.out.println("This should print out 3: " + testList.back().item);
		System.out.println("\nTesting next method");
		testList.insertFront(5);
		System.out.println("Should be [ 5 1 3 ]: " + testList);
		DListNode testingNode = testList.next(testList.front());
		System.out.println("This should print out 1: " + testingNode.item);
		testingNode = testList.next(testingNode);
		System.out.println("This should print out 3: " + testingNode.item);
		System.out.println("\nTesting prev method");
		testingNode = testList.prev(testingNode);
		System.out.println("This should print out 1: " + testingNode.item);
		System.out.println("\nTesting insertBefore");
		testList.insertBefore(10, testingNode);
		System.out.println("Should print out [ 5 10 1 3 ]: " + testList);
		System.out.println("\nTesting insertAfter");
		testList.insertAfter(40, testingNode);
		System.out.println("Should be [ 5 10 1 40 3 ]: " + testList);
		System.out.println("\nRemoving node");
		testList.remove((LockDListNode)testingNode);
		System.out.println("Should be [ 5 10 40 3 ]: " + testList);
		System.out.println("Length should be 4:" + testList.length());
	
		System.out.println("Testing Constructor");
		LockDList testList2 = new LockDList();
		System.out.println("Is empty? Should be true: " + testList2.isEmpty());
		System.out.println("Should be zero length: " + testList2.length());

		System.out.println("\nTesting insertFront");
		testList2.insertFront(1);
		System.out.println("Is empty? Should be false: " + testList2.isEmpty());
		System.out.println("Should be one length: " + testList2.length());
		System.out.println("Should be [ 1 ]: " + testList2);
		testList2.insertFront(3);
		testList2.insertFront(6);
		testList2.insertFront(9);
		System.out.println(testList2);

		LockDListNode currNode = (LockDListNode) ((DList) testList2).front();
		currNode = (LockDListNode) testList2.next(currNode);
		currNode = (LockDListNode) testList2.next(currNode);
		//testList.lockNode(currNode);
		testList2.remove(currNode);

		System.out.println(testList2);


	        LockDList l = new LockDList();
			System.out.println("\n\n###Testing insertFront ###\nEmpty list is" + l);
			l.insertFront(9);
			System.out.println("\nInserting 9 at front. \nList with 9 is " + l);
			l.insertFront(8);
			l.insertFront(7);
			System.out.println("\nInserting 7, 8 at the front. \nList with 7, 8, 9 is " + l);
			l.insertAfter(6, l.head);
			System.out.println("\nInserting 6 after head. nList with 6, 7, 8, 9 is "+l);
			l.remove(l.head.next);
			System.out.println("Removed head.next, should return a list of 7, 8, 9. nList with 7, 8, 9 is " + l);
			LockDList m = new LockDList();
			m.insertFront(9);
			m.insertFront(8);
			m.insertFront(7);
			System.out.println("\nInserting 7, 8, 9 at the front. List with 7, 8, 9 is " + m);
			m.lockNode(m.head.next);
			m.remove(m.head.next);
			System.out.println("Locked the first element of the DList, should not be removed. List with 7, 8, 9 is " + m);
	}

}
