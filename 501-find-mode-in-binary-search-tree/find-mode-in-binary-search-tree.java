/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Integer> freqMap = new HashMap<>();
    private int maxFreq = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer> modes = new ArrayList<>();
        for (int val : freqMap.keySet()) {
            if (freqMap.get(val) == maxFreq) {
                modes.add(val);
            }
        }
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        freqMap.put(root.val, freqMap.getOrDefault(root.val, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(root.val));
        inorder(root.right);
    }
}