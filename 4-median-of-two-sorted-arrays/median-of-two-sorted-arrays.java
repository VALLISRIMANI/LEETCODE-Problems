class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int index = 0;

        for (int num : nums1) {
            arr[index++] = num;
        }
        for (int num : nums2) {
            arr[index++] = num;
        }

        Arrays.sort(arr);

        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }
}