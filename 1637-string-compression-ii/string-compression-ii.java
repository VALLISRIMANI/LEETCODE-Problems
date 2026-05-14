class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        Integer[][] memo = new Integer[n + 1][k + 1];
        return dp(0, k, s, memo);
    }
    private int dp(int i, int k, String s, Integer[][] memo) {
        if (k < 0) return Integer.MAX_VALUE; 
        if (i >= s.length() || s.length() - i <= k) return 0; 
        if (memo[i][k] != null) return memo[i][k];
        int res = Integer.MAX_VALUE;
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int j = i; j < s.length(); j++) {
            freq[s.charAt(j) - 'a']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'a']);
            int deletions = (j - i + 1) - maxFreq;
            if (deletions > k) continue;
            int compressedLen = getCompressedLength(maxFreq);
            int next = dp(j + 1, k - deletions, s, memo);
            if (next != Integer.MAX_VALUE) {
                res = Math.min(res, compressedLen + next);
            }
        }
        memo[i][k] = res;
        return res;
    }
    private int getCompressedLength(int count) {
        if (count == 1) return 1;
        if (count < 10) return 2;
        if (count < 100) return 3;
        return 4;
    }
}