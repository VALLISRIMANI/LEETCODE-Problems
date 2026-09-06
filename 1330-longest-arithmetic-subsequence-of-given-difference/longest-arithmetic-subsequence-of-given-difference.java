class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        /*
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num + difference)) {
                int current = num;
                int currentLength = 1;

                while (set.contains(current - difference)) {
                    current -= difference;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
        */

        HashMap<Integer, Integer> dp = new HashMap<>();

        int maxLength = 0;
        for (int num : arr) {
            int length = dp.getOrDefault((num - difference), 0) + 1;
            dp.put(num, length);

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}