class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = -1;

        for (String sentence : sentences) {
            int words = 1;
            for (char ch : sentence.toCharArray()) {
                if (ch == ' ') {
                    words++;
                }
            }

            max = Math.max(max, words);
        }

        return max;
    }
}