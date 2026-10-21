class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int currSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            result.add(nums[i]);

            if (currSum > (totalSum - currSum)) break;
        }

        return result;
    }
}