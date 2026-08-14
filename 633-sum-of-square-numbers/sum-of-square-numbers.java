class Solution {
    public boolean judgeSquareSum(int c) {
        long square = (long) Math.sqrt(c);

        long i = 0, j = square;
        while (i <= j) {
            long temp = i * i + j * j;
            if (temp == c) {
                return true;
            } else if (temp < c) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}