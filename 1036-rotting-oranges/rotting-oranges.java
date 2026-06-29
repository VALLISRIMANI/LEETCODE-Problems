class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0, time = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    total++;
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        int total1 = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int rottenOranges = q.size();

            for (int i = 0; i < rottenOranges; i++) {
                int[] rotten = q.poll();

                for (int j = 0; j < 4; j++) {
                    int x = rotten[0] + dx[j];
                    int y = rotten[1] + dy[j];

                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    total--;
                }
            }

            if (q.size() != 0) {
                time++;
            }
        }

        return total == 0 ? time : -1;
    }
}