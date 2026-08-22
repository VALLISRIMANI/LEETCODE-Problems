class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = 0;

        int n = nums.length;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        maxAverage = sum / k;

        for (int i = k; i < n; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxAverage = Math.max(maxAverage, sum / k);
        }

        return maxAverage;
    }
}