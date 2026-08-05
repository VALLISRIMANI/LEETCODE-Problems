class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : new HashSet<Integer>() {{
            for (int x : nums1) add(x);
        }})
            map.put(num, map.getOrDefault(num, 0) | 1);

        for (int num : new HashSet<Integer>() {{
            for (int x : nums2) add(x);
        }})
            map.put(num, map.getOrDefault(num, 0) | 2);

        for (int num : new HashSet<Integer>() {{
            for (int x : nums3) add(x);
        }})
            map.put(num, map.getOrDefault(num, 0) | 4);

        List<Integer> ans = new ArrayList<>();

        for (int num : map.keySet()) {
            if (Integer.bitCount(map.get(num)) >= 2) {
                ans.add(num);
            }
        }

        return ans;
    }
}