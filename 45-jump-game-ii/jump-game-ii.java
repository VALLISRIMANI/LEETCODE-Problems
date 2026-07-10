class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int maxReach = 0, currentEnd = 0, minJumps = 0;

        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (i == currentEnd) {
                minJumps++;
                currentEnd = maxReach;

                if (maxReach >= n - 1) {
                    break;
                }
            }
        }

        return minJumps;
    }
}