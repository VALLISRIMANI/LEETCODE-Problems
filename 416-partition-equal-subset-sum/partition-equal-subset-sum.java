class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        return isSubsetSum(nums, nums.length, targetSum);
    }
    private static boolean isSubsetSum(int[] arr, int n, int targetSum) {
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= targetSum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][targetSum];
    }
}