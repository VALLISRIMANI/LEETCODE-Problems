class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int m = queries.length;
        int[] result = new int[m];

        HashMap<Integer, Integer> ballColor = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();        

        for (int i = 0; i < m; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];

            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);

                int cnt = colorCount.get(oldColor) - 1;
                if (cnt == 0) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, cnt);
                }
            }

            ballColor.put(ball, newColor);
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);

            result[i] = colorCount.size();
        }

        return result;
    }
}