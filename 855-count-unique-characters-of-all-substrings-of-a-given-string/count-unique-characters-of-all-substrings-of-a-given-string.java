class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();

        int[] prev = new int[256];
        int[] last = new int[256];

        Arrays.fill(prev, -1);
        Arrays.fill(last, -1);

        int result = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (last[ch] != -1) {
                result += (last[ch] - prev[ch]) * (i - last[ch]);
            }

            prev[ch] = last[ch];
            last[ch] = i;
        }

        for (int ch = 0; ch < 256; ch++) {
            if (last[ch] != -1) {
                result += (last[ch] - prev[ch]) * (n - last[ch]);
            }
        }

        return result;
    }
}