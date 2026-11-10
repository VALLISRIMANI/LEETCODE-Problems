class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String word : dictionary) {
            if (word.length() < result.length() || (word.length() == result.length() && word.compareTo(result) > 0)) {
                continue;
            }

            if (isSubsequence(word, s)) {
                result = word;
            }
        }
        
        return result;
    }

    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;

        int wordLen = word.length();
        int sLen = s.length();

        while (i < wordLen && j < sLen) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == wordLen;
    }
}