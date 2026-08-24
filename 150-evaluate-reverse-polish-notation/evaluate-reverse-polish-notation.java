class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int num1 = st.pop(), num2 = st.pop();
                st.push(num2 + num1);
            } else if (str.equals("-")) {
                int num1 = st.pop(), num2 = st.pop();
                st.push(num2 - num1); 
            } else if (str.equals("*")) {
                int num1 = st.pop(), num2 = st.pop();
                st.push(num2 * num1); 
            } else if (str.equals("/")) {
                int num1 = st.pop(), num2 = st.pop();
                st.push(num2 / num1); 
            } else {
                st.push(Integer.parseInt(str));
            }
        }

        return st.peek();
    }
}