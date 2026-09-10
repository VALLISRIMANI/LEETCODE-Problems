class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int count = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count -= 1;
            if (nums[i] == 1) count += 1;

            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(count));
            }
        }

        return maxLen;
    }
}