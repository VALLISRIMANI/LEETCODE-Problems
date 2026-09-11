class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                maxSum = Math.max(maxSum, sum);
                sum = 0;
            }
            
            sum += nums[i];
        }
        
        maxSum = Math.max(maxSum, sum);

        return maxSum;
    }
}