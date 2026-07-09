class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int last = groups[0];
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != last) {
                res.add(words[i]);
                last = groups[i];
            }
        }
        return res;
    }
}