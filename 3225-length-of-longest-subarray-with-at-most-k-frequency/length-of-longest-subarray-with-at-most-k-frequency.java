class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            int rightNum = nums[right];
            map.put(rightNum, map.getOrDefault(rightNum, 0) + 1);

            while (map.get(rightNum) > k) {
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);

                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }
                
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}