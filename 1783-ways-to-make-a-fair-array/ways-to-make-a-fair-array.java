class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }

        int count = 0;
        int leftEvenSum = 0;
        int leftOddSum = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenSum -= nums[i];
            } else {
                oddSum -= nums[i];
            }

            if (leftEvenSum + oddSum == leftOddSum + evenSum) {
                count++;
            }

            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }

        return count;
    }
}