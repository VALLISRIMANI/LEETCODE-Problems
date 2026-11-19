class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Integer> st = new Stack<>();

        for (char ch : num.toCharArray()) {
            int digit = ch - '0';

            while (!st.isEmpty() && k > 0 && digit < st.peek()) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        String result = sb.reverse().toString().replaceFirst("^0+", "");
        return result.isEmpty() ? "0" : result;
    }
}