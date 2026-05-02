class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int unique = 0, countAtLeastK = 0;
            while (right < n) {
                int idx = s.charAt(right) - 'a';
                if (freq[idx] == 0) unique++;
                freq[idx]++;
                if (freq[idx] == k) countAtLeastK++;
                right++;
                while (unique > uniqueTarget) {
                    int leftIdx = s.charAt(left) - 'a';
                    if (freq[leftIdx] == k) countAtLeastK--;
                    freq[leftIdx]--;
                    if (freq[leftIdx] == 0) unique--;
                    left++;
                }
                if (unique == uniqueTarget && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}