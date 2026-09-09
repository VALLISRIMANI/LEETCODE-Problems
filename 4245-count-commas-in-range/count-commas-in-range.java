class Solution {
    public int countCommas(int n) {
        int result = 0;
        int start = 1000;

        while (start <= n) {
            result += n - start + 1;

            start *= 1000;
        }

        return result;
    }
}