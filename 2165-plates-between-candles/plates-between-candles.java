class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int starsCount = 0;
        int[] previousStars = new int[n];
        int[] nextPlate = new int[n];
        int[] prevPlate = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                starsCount++;
            }
            previousStars[i] = starsCount;
        }

        int lastIdx = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastIdx = i;
            }
            prevPlate[i] = lastIdx;
        }

        lastIdx = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastIdx = i;
            }
            nextPlate[i] = lastIdx;
        }

        int[] result = new int[queries.length];
        int idx = 0;

        for (int q = 0; q < queries.length; q++) {
            int start = queries[q][0];
            int end = queries[q][1];

            int leftBoundary = nextPlate[start];
            int rightBoundary = prevPlate[end];

            if (leftBoundary != -1 && rightBoundary != -1 && leftBoundary < rightBoundary) {
                result[idx++] = previousStars[rightBoundary] - previousStars[leftBoundary];
            } else {
                result[idx++] = 0;
            }
        }

        return result;
    }
}