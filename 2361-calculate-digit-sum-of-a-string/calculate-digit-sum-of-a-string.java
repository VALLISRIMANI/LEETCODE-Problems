class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > k) {
            sb = sum(sb.toString(), k);
        }

        return sb.toString();
    }

    public StringBuilder sum(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < n) {
            if (idx + k < n) {
                int sum = 0;

                for (int i = idx; i < idx + k; i++) {
                    sum += s.charAt(i) - '0';
                }

                sb.append(sum);
            } else {
                int sum = 0;

                for (int i = idx; i < n; i++) {
                    sum += s.charAt(i) - '0';
                }

                sb.append(sum);
            }

            idx += k;
        }

        return sb;
    }
}