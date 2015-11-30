package cs61b.src.hw4;

public class LockDList extends DList{
	public void lockNode(DListNode node){
		((LockDListNode)node).isLooked = true;
	}
	
	protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
	    return new LockDListNode(item, prev, next);
	}
	
	public void remove(DListNode node) {
		if(((LockDListNode)node).isLooked == false){
			super.remove(node);
		}
	}
}
