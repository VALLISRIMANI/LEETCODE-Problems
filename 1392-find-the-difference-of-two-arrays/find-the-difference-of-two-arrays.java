class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> diff1 = new ArrayList<>();
        for (int num : nums1) {
            if (!set2.contains(num)) {
                if (!diff1.contains(num)) {
                    diff1.add(num);
                }
            }
        }
        result.add(diff1);

        List<Integer> diff2 = new ArrayList<>();
        for (int num : nums2) {
            if (!set1.contains(num)) {
                if (!diff2.contains(num)) {
                    diff2.add(num);
                }
            }
        }
        result.add(diff2);

        return result;
    }
}