class Solution {
    public int minimumOneBitOperations(int n) {
        int result = n;

        while (n > 0) {
            n >>= 1;
            result ^= n;
        }

        return result;
    }
}