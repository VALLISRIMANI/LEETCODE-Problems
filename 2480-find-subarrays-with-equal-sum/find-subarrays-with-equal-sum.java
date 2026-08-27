class Solution {
    public boolean findSubarrays(int[] nums) {
        /*
        int partialSum = 0;
        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            partialSum += nums[i];

            if(partialSum == totalSum) {
                return true;
            } 

            totalSum -= nums[i];
        }

        return false; 
        */

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];

            if (set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
}