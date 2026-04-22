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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        } 

        if (count == k) {
            ListNode prev = null;
            ListNode curr = head;

            for (int i = 0; i < k; i++) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            head.next = reverseKGroup(curr, k);
            return prev;
        }

        return head;
    }
}