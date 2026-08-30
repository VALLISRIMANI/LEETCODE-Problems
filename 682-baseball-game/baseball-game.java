class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String s : operations) {
            if (s.equals("C")) {
                st.pop();
            } else if (s.equals("D")) {
                st.push(2 * st.peek());
            } else if (s.equals("+")) {
                int n2 = st.pop();
                int n1 = st.peek();
                st.push(n2);
                st.push(n1 + n2);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}