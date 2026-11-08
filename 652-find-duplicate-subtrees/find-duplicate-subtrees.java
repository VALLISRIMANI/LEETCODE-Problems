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
    HashMap<String, Integer> ids = new HashMap<>();
    HashMap<Integer, Integer> freq = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        String key = node.val + "," + left + "," + right;
        int id = ids.computeIfAbsent(key, k -> ids.size() + 1);

        int count = freq.getOrDefault(id, 0);

        if (count == 1) result.add(node);

        freq.put(id, count + 1);

        return id;
    }
}