class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int currentSum = 0, subarraysCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            currentSum += num % 2;

            if (map.containsKey(currentSum - k)) {
                subarraysCount += map.get(currentSum - k);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return subarraysCount;
    }
}