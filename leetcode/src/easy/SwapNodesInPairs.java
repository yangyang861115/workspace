package easy;

import easy.LinkedListCycle.ListNode;

/*
 * 24
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * */
public class SwapNodesInPairs {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //recursive
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
    
    //non-recursive
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode newHead = head.next;
        ListNode a = head, b = head.next, pre = null;
        while(a != null && b!= null){
            a.next = b.next;
            b.next = a;
            if(pre != null) pre.next = b;
            pre = a;
            a = a.next;
            if(a == null) break;
            b = a.next;
        }
        return newHead;
        
    }
}
