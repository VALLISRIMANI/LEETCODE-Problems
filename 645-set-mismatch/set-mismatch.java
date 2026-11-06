class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1, missing = -1;
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!countMap.containsKey(i)) {
                missing = i;
            } else if (countMap.get(i) == 2) {
                dup = i;
            }
        }
        
        return new int[] { dup, missing };
    }
}