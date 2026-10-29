class Solution {
     class Pair {
        char ch;
        int count;
        
        Pair (char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == ch) {
                st.peek().count++;
            } else {
                st.push(new Pair(ch, 1));
            }
            
            if (st.peek().count == k) {
                st.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Pair p : st) {
            sb.append(String.valueOf(p.ch).repeat(p.count));
        }
        
        return sb.toString();
    }    
}