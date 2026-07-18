class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char digit = board[r][c];

                if (digit == '.') continue;

                int box = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(digit) ||
                    cols[c].contains(digit) ||
                    boxes[box].contains(digit)) {
                        return false;
                }

                rows[r].add(digit);
                cols[c].add(digit);
                boxes[box].add(digit);
            }
        }

        return true;
    }
}