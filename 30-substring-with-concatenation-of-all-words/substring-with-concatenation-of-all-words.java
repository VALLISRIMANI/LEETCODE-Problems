class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        /*
        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) return res;
        
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                int start = i + j * wordLen;
                String word = s.substring(start, start + wordLen);
                if (!wordCount.containsKey(word)) break;
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > wordCount.get(word)) break;
                j++;
            }
            if (j == words.length) res.add(i);
        }
        
        return res;
        */

        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) return result;

        int wordCountTotal = words.length;
        int wordLen = words[0].length();
        int totalLen = wordLen * wordCountTotal;

        if (s.length() < totalLen) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int right = offset;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (!wordCount.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > wordCount.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCountTotal) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            }
        }

        return result;
    }
}