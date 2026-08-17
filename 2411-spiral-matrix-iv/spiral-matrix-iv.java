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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(matrix[i], -1);

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        ListNode temp = head;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right && temp != null; j++) {
                matrix[top][j] = temp.val;
                temp = temp.next;
            }
            top++;

            for (int i = top; i <= bottom && temp != null; i++) {
                matrix[i][right] = temp.val;
                temp = temp.next;
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left && temp != null; j--) {
                    matrix[bottom][j] = temp.val;
                    temp = temp.next;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top && temp != null; i--) {
                    matrix[i][left] = temp.val;
                    temp = temp.next;
                }
                left++;
            }
        }

        return matrix;
    }
}