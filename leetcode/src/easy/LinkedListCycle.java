package easy;

/*
 * 141
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * run step 1 and 2
 * */
public class LinkedListCycle {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode node1 = head.next;
        ListNode node2 = head.next.next;
        while (node2 != null && node2.next != null) {
            if (node1.val == node2.val)
                return true;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return false;
    }
}
