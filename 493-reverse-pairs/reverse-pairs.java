class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int m = l + (r - l) / 2;

        int count = 0;
        count += mergeSort(nums, l, m);
        count += mergeSort(nums, m + 1, r);
        count += merge(nums, l, m, r);

        return count;
    }

    static int merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = nums[m + 1 + i];
        }

        int invCount = 0;

        // Count reverse pairs
        int j = 0;
        for (int i = 0; i < n1; i++) {
            while (j < n2 && (long) L[i] > 2L * R[j]) {
                j++;
            }
            invCount += j;
        }

        // Normal merge
        int i = 0;
        j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

        while (i < n1) {
            nums[k++] = L[i++];
        }

        while (j < n2) {
            nums[k++] = R[j++];
        }

        return invCount;
    }
}