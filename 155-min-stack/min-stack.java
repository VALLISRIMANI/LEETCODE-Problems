class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);

        if (minSt.isEmpty()) {
            minSt.push(value);
        } else {
            minSt.push(Math.min(value, minSt.peek()));
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
            minSt.pop();
        }
    }
    
    public int top() {
        return !st.isEmpty() ? st.peek() : -1;
    }
    
    public int getMin() {
        return !minSt.isEmpty() ? minSt.peek() : -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */