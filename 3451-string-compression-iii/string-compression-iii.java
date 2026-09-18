class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char prevChar = word.charAt(0);
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == prevChar && count < 9) {
                count++;
            } else {
                sb.append(count).append(prevChar);
                prevChar = ch;
                count = 1;
            }
        }

        sb.append(count).append(prevChar);

        return sb.toString();
    }
}