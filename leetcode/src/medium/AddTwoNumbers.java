package medium;
/*
 * 2
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * */
public class AddTwoNumbers {
    //Definition for singly-linked list.
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int val = (l1 == null ? 0: l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode node = new ListNode(val % 10);
            carry = val / 10;
            cur.next = node;
            cur = cur.next;
            l1 = (l1==null ? l1 : l1.next);
            l2 = (l2==null ? l2 : l2.next);
        }
        
        return pre.next;
    }
}
