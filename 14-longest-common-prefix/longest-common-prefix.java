class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String word1 = strs[0], word2 = strs[strs.length - 1];
        int i = 0;
        int length = Math.min(word1.length(), word2.length());

        StringBuilder sb = new StringBuilder();
        while (i < length) {
            if (word1.charAt(i) != word2.charAt(i)) {
                break;
            }
            sb.append(word1.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
}