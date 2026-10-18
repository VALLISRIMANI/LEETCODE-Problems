class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int nr = i + d[0];
                        int nc = j + d[1];

                        if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}