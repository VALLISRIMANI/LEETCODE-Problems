class Solution {
    public int minStartValue(int[] nums) {
        int prefixSum = 0;
        int minPrefix = Integer.MAX_VALUE;

        for (int num : nums) {
            prefixSum += num;
            minPrefix = Math.min(minPrefix, prefixSum);
        }

        // If minPrefix >= 0, startValue = 1 is enough
        return minPrefix >= 0 ? 1 : 1 - minPrefix;
    }
}