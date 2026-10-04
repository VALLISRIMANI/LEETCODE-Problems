class Solution {
    public int maximumValue(String[] strs) {
        int maxLength = Integer.MIN_VALUE;

        for (String s : strs) {
            if (s.matches(".*[A-Za-z].*")) {
                maxLength = Math.max(maxLength, s.length());
            } else {
                maxLength = Math.max(maxLength, Integer.parseInt(s));
            }
        }

        return maxLength;
    }
}