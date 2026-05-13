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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp1 = head;

        while (temp1 != null) {
            st.push(temp1);
            temp1 = temp1.next;
        }

        ListNode temp2 = head;
        while (!st.isEmpty()) {
            if (temp2.val != st.pop().val) return false;
            temp2 = temp2.next;
        }

        return true;
    }
}