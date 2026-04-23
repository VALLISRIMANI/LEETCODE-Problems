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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        int count = 1;

        // Count and move to tail 
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        // Apply modulus to k, so that we can get k greater than count 
        // k = 8, count = 5, correct k = 8 % 5 = 3
        k = k % count;
        if (k == 0) return head;

        // Make the linked list circular
        temp.next = head;

        // Find out new tail, for that move upto count - k (No.of rotations)
        ListNode newTail = head;
        for (int i = 1; i < count - k; i++) {
            newTail = newTail.next;
        }

        // Assign new head to new tail next
        ListNode newHead = newTail.next;
        // Make new tail next to null, so that it will be back linked list again
        newTail.next = null;

        // Return the new head
        return newHead;
    }
}