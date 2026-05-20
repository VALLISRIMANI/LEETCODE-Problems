class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            if (i < n) {
                if (!st.isEmpty()) {
                    result[i] = st.peek();
                }
            }

            st.push(current);
        }

        return result;
    }
}