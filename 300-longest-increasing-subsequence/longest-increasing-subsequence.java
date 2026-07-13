class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > result[len - 1]) {
                result[len] = nums[i];
                len++;
            } else {
                int low = Arrays.binarySearch(result, 0, len, nums[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                result[low] = nums[i];
            }
        }

        return len;
    }
}