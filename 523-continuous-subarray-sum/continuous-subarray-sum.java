class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s = (s + nums[i]) % k;
            if (!map.containsKey(s)) {
                map.put(s, i);
            } else {
                if (i - map.get(s) > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}