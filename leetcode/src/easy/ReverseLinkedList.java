package easy;

/*
 * 206
 * Reverse a singly linked list.
 * */
public class ReverseLinkedList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode node = null;
        while (head.next != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = node;
            node = tmp;
        }
        head.next = node;
        return head;
    }
}
