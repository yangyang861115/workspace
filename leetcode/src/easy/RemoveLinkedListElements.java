package easy;

import easy.RemoveDuplicatesFromSortedList.ListNode;

/*
 * 203
 * Remove all elements from a linked list of integers that have value val.
 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 * */
public class RemoveLinkedListElements {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode node = new ListNode(0);
        ListNode node2 = node;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
                node.next = head;
            } else {
                node.next = head;
                head = head.next;
                node = node.next;
            }

        }

        return node2.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;
        
        head.next = removeElements2(head.next, val);
        
        return head.val == val ? head.next: head;
    }    
        

}
