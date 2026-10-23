class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> diagonal1 = new HashSet<>();
        HashSet<Integer> diagonal2 = new HashSet<>();

        backtrack(0, n, columns, diagonal1, diagonal2);

        return count;
    }

    private void backtrack(
        int row,
        int n,
        HashSet<Integer> columns,
        HashSet<Integer> diagonal1,
        HashSet<Integer> diagonal2
    ) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            if (columns.contains(col) ||
                diagonal1.contains(row - col) ||
                diagonal2.contains(row + col)) {

                continue;
            }

            columns.add(col);
            diagonal1.add(row - col);
            diagonal2.add(row + col);

            backtrack(
                row + 1,
                n,
                columns,
                diagonal1,
                diagonal2
            );

            columns.remove(col);
            diagonal1.remove(row - col);
            diagonal2.remove(row + col);
        }
    }
}