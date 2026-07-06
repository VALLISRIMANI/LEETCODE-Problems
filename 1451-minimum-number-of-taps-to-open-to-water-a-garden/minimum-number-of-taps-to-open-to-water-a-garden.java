/* class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n; i++) {
            dp[i] = n + 1;
        }

        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            if (dp[start] == n + 1) {
                continue;
            }

            for (int j = start; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }

        return dp[n] == n + 1 ? -1 : dp[n];
    }
}
*/

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxReach[left] = Math.max(maxReach[left], right);
        }

        int taps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, maxReach[i]);

            if (i == currentEnd) {
                if (farthest == currentEnd) {
                    return -1;
                }

                taps++;
                currentEnd = farthest;

                if (currentEnd >= n) {
                    return taps;
                }
            }
        }

        return currentEnd >= n ? taps : -1;
    }
}