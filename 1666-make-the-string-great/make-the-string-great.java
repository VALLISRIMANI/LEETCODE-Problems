class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                // Check if last and current form a bad pair
                if (Math.abs(last - ch) == 32) { // ASCII difference between 'a' and 'A'
                    sb.deleteCharAt(sb.length() - 1); // remove last
                    continue; // skip current
                }
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
