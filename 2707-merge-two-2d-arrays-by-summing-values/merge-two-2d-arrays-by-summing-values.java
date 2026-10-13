class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];

            int id2 = nums2[j][0];
            int val2 = nums2[j][1];

            if (id1 == id2) {
                ans.add(Arrays.asList(id1, val1 + val2));
                i++;
                j++;
            } else if (id1 < id2) {
                ans.add(Arrays.asList(id1, val1));
                i++;
            } else {
                ans.add(Arrays.asList(id2, val2));
                j++;
            }
        }

        while (i < nums1.length) {
            ans.add(Arrays.asList(nums1[i][0], nums1[i][1]));
            i++;
        }

        while (j < nums2.length) {
            ans.add(Arrays.asList(nums2[j][0], nums2[j][1]));
            j++;
        }

        int[][] result = new int[ans.size()][2];

        for (int idx = 0; idx < ans.size(); idx++) {
            result[idx][0] = ans.get(idx).get(0);
            result[idx][1] = ans.get(idx).get(1);
        }

        return result;
    }
}