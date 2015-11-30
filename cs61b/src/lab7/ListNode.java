package lab7;

import hw5.list.DListNode;

/* ListNode.java */

/**
 *  ListNode is a very simple headless list class, akin to cons cells in
 *  Scheme.  Each ListNode contains an item and a reference to the next node.
 **/
class ListNode {

  public Object item;
  public ListNode next;

  /**
   *  Constructs a ListNode with item i and next node n.
   *  @param i the item to store in the ListNode.
   *  @param n the next ListNode following this ListNode.
   **/
  ListNode(Object i, ListNode n) {
    item = i;
    next = n;
  }
  
  public String toString() {
	    String result = "[  ";
	    ListNode h = this;
	    while (h.next != null) {
	      result = result + h.item + "  ";
	      h = h.next;
	    }
	    result = result + h.item + "  ";
	    return result + "]";
	  }
}
