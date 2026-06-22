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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        ListNode curr1 = l1;
        while (curr1 != null) {
            st1.push(curr1.val);
            curr1 = curr1.next;
        }

        ListNode curr2 = l2;
        while (curr2 != null) {
            st2.push(curr2.val);
            curr2 = curr2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            int num1 = (!st1.isEmpty()) ? st1.pop() : 0;
            int num2 = (!st2.isEmpty()) ? st2.pop() : 0;
            
            int sum = num1 + num2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            ListNode node = new ListNode(digit);
            node.next = head;
            head = node;
        }
        
        while (head != null && head.val == 0 && head.next != null) {
            head = head.next;
        }
        
        return head;
    }
}