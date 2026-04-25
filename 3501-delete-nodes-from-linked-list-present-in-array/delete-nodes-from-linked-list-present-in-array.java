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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            seen.add(num);
        }

        ListNode curr = head, prev = null;

        while (curr != null) {
            if (seen.contains(curr.val) && prev == null) {
                curr = curr.next;
                head = curr;
            } else if (seen.contains(curr.val)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}