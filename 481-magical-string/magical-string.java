class Solution {
    public int magicalString(int n) {
        if (n <= 3) {
            return n == 1 ? 1 : 1;
        }

        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int count = 3;
        int ones = 1;
        int i = 2;
        int num = 1;

        while (count < n) {
            int freq = s[i];

            for (int j = 0; j < freq && count < n; j++) {
                s[count] = num;

                if (num == 1) {
                    ones++;
                }

                count++;
            }

            num = 3 - num;
            i++;
        }

        return ones;
    }
}