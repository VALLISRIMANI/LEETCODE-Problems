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
    public void reorderList(ListNode head) {
        /*
            ## Approach 1: Using a Stack (O(n) Space)

            ### Steps

            1. **Find the middle** of the linked list using slow and fast pointers.
            2. **Push all nodes of the second half** onto a stack and disconnect the two halves.
            3. **Traverse the first half**, and after each node, pop one node from the stack and insert it between the current node and the next node.
            4. **Continue until the stack becomes empty**, resulting in the reordered list.

            ### Complexity

            * **Time:** O(n)
            * **Space:** O(n)

            ---

            ## Approach 2: Reverse Second Half (Optimal - O(1) Space)

            ### Steps

            1. **Find the middle** of the linked list using slow and fast pointers.
            2. **Split the list** into two halves and **reverse the second half** in-place.
            3. **Merge the two halves alternately** by taking one node from the first half and one node from the reversed second half.
            4. **Continue until all nodes are merged**, producing the reordered list.

            ### Complexity

            * **Time:** O(n)
            * **Space:** O(1)
        */

        ListNode middle = middleNode(head);

        ListNode firstHalf = head;
        ListNode secondHalf = middle.next;
        middle.next = null;

        secondHalf = reverse(secondHalf);
        
        ListNode temp1 = firstHalf, temp2 = secondHalf;

        while (temp1 != null && temp2 != null) {
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;

            temp1.next = temp2;
            temp2.next = next1;

            temp1 = next1;
            temp2 = next2;
        }

    }

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}