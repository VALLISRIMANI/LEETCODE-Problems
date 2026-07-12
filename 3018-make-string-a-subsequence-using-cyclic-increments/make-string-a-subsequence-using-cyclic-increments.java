class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        /*
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (str1.indexOf(ch) == -1) {
                char prev = (char) (((ch - 'a' - 1) + 26) % 26 + 'a');
                if (str1.indexOf(prev) == -1) {
                    return false;
                }
            }
        }

        return true;
        */

        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            char ch = str1.charAt(i);
            char next = (char) ((ch - 'a' + 1) % 26 + 'a');

            if (ch == str2.charAt(j) || next == str2.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == str2.length();
    }
}