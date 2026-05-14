class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1; // current sign (+1 or -1)
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // build number
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // push current result and sign
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // pop sign
                result += stack.pop(); // pop previous result
            }
        }
        return result + sign * num; // add last number
    }
}