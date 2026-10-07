class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int groups = 1, minGroups = 1;

        int i = 1, j = 0;
        while (i < n) {
            if (startTimes[i] <= endTimes[j]) {
                groups++;
                minGroups = Math.max(minGroups, groups);
                i++;
            } else {
                groups--;
                j++;
            }
        }

        return minGroups;
    }
}