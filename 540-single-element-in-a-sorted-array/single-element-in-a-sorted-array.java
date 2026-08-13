class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        return search(nums, low, high);
    }

    public int search(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;

        if (mid % 2 != 0) {
            mid = mid - 1;
        }

        if (nums[mid] == nums[mid + 1]) {
            return search(nums, mid + 2, high);
        } 

        return search(nums, low, mid);
    }
}