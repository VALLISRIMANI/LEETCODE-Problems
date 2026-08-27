class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            result[i] = prices[i];

            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                int idx = st.pop();
                result[idx] = prices[idx] - prices[i];
            }
            st.push(i);
        }

        return result;
    }
}