/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode lessHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode less = lessHead, greater = greaterHead;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                less.next = temp;
                less = less.next;
            } else {
                greater.next = temp;
                greater = greater.next;
            }

            temp = temp.next;
        }

        greater.next = null;
        
        less.next = greaterHead.next;
        return lessHead.next;
    }
}