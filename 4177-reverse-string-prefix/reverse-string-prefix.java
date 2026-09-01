class Solution {
    public String reversePrefix(String s, int k) {
        if (k == 1) return s;

        String firstHalf = s.substring(0, k);
        String secondHalf = s.substring(k, s.length());
        StringBuilder sb = new StringBuilder(firstHalf);
        sb.reverse().append(secondHalf);

        return sb.toString();
    }
}