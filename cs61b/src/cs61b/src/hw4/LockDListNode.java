package cs61b.src.hw4;

public class LockDListNode extends DListNode{
	protected boolean isLooked;
	LockDListNode(Object i, DListNode p, DListNode n) {
		super(i, p, n);
		isLooked = false;
	}
}
