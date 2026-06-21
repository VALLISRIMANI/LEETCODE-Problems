class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] best = new int[k];

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] subseq1 = maxSubsequence(nums1, i);
            int[] subseq2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(subseq1, subseq2);
            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }
        return best;
    }

    private int[] maxSubsequence(int[] nums, int t) {
        int[] stack = new int[t];
        int top = -1;
        int toDrop = nums.length - t;

        for (int num : nums) {
            while (top >= 0 && stack[top] < num && toDrop > 0) {
                top--;
                toDrop--;
            }
            if (top + 1 < t) {
                stack[++top] = num;
            } else {
                toDrop--;
            }
        }
        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, r = 0;

        while (i < nums1.length || j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                res[r++] = nums1[i++];
            } else {
                res[r++] = nums2[j++];
            }
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++; j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }


}