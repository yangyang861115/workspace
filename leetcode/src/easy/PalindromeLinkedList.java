package easy;

import easy.RemoveNthNodeFromEndOfList.ListNode;

/*
 * 234
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:Could you do it in O(n) time and O(1) space?
 * */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)
            slow = slow.next;

        slow = reverse(slow);
        while (slow != null && slow.val == head.val) {
            slow = slow.next;
            head = head.next;
        }
        return slow == null;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
