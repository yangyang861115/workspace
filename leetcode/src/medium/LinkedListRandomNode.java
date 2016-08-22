package medium;

import java.util.*;

/*
 * 382. Linked List Random Node 
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *  
 * */
public class LinkedListRandomNode {
    
    private ArrayList<Integer> mylist;
    private int size = 0;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        mylist = new ArrayList<Integer>();
        while(head != null) {
            mylist.add(head.val);
            head = head.next;
            size++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int rand = (int)(Math.random() * size);
        return mylist.get(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
