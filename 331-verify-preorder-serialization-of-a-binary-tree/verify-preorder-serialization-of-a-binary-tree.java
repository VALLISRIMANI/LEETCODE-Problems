class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        List<String> stack = new ArrayList<>();

        for (String node : nodes) {
            stack.add(node);

            while (stack.size() >= 3 
                    && stack.get(stack.size() - 1).equals("#")
                    && stack.get(stack.size() - 2).equals("#")
                    && !stack.get(stack.size() - 3).equals("#")
            ) {
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.add("#");
            }
        }

        return stack.size() == 1 && stack.get(0).equals("#");
    }
}