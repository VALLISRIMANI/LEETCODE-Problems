class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> diagonal1 = new HashSet<>();
        HashSet<Integer> diagonal2 = new HashSet<>();

        backtrack(0, n, board, columns, diagonal1, diagonal2);

        return result;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board,
        HashSet<Integer> columns,
        HashSet<Integer> diagonal1,
        HashSet<Integer> diagonal2
    ) {
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columns.contains(col) ||
                diagonal1.contains(row - col) ||
                diagonal2.contains(row + col)) {

                continue;
            }

            board[row][col] = 'Q';

            columns.add(col);
            diagonal1.add(row - col);
            diagonal2.add(row + col);

            backtrack(
                row + 1,
                n,
                board,
                columns,
                diagonal1,
                diagonal2
            );

            board[row][col] = '.';

            columns.remove(col);
            diagonal1.remove(row - col);
            diagonal2.remove(row + col);
        }
    }
}