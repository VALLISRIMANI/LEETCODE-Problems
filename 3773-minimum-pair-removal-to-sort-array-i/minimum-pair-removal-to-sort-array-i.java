class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;
        while (!isSorted(nums)) {
            int idx = findMinPairIndex(nums);
            int[] newArr = new int[nums.length - 1];
            int k = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i == idx) {
                    newArr[k++] = nums[i] + nums[i + 1];
                    i++;
                } else {
                    newArr[k++] = nums[i];
                }
            }

            nums = newArr;
            ops++;
        }

        return ops;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }

        return true;
    }

    private int findMinPairIndex(int[] nums) {
        int minSum = Integer.MAX_VALUE, idx = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];

            if (sum < minSum) {
                minSum = sum;
                idx = i;
            }
        }

        return idx;
    }
}