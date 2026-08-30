/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node temp = st.pop();
            result.add(temp.val);

            for (int i = temp.children.size() - 1; i >= 0; i--) {
                st.push(temp.children.get(i));
            }
        }

        return result;
    }
}