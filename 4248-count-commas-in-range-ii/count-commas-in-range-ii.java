class Solution {
    public long countCommas(long n) {
        long[][] ranges = {
            {1000L, 1000000L, 1},
            {1000000L, 1000000000L, 2},
            {1000000000L, 1000000000000L, 3},
            {1000000000000L, 1000000000000000L, 4},
            {1000000000000000L, 10000000000000000L, 5}
        };
        
        long total = 0;
        for (long[] r : ranges) {
            long low = r[0], high = r[1], commas = r[2];
            if (n >= low) {
                total += (Math.min(n, high - 1) - low + 1) * commas;
            }
        }
        return total;
    }
}