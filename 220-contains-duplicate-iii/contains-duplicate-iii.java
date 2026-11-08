class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        long w = (long) valueDiff + 1;

        Map<Long, Long> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long id = Math.floorDiv(num, w);

            if (buckets.containsKey(id)) {
                return true;
            }

            if (buckets.containsKey(id - 1) && num - buckets.get(id - 1) <= valueDiff) {
                return true;
            }

            if (buckets.containsKey(id + 1) && buckets.get(id + 1) - num <= valueDiff) {
                return true;
            }

            buckets.put(id, num);

            if (i >= indexDiff) {
                long oldId = Math.floorDiv((long) nums[i - indexDiff], w);

                buckets.remove(oldId);
            }
        }

        return false;
    }
}