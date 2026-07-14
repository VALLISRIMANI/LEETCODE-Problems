class Solution {
    int[][] dir = {
        {-1, 0},
        {1, 0}, 
        {0, -1},
        {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        if (board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];

            if (dfs(board, word, r, c, index + 1)) {
                return true;
            }
        }

        board[i][j] = temp;

        return false;
    }
}