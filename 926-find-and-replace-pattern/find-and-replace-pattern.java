class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String s : words) {
            if (s.length() != pattern.length()) {
                continue;
            }

            HashMap<Character, Character> patternToWord = new HashMap<>();
            HashMap<Character, Character> wordTopattern = new HashMap<>();

            boolean match = true;
            for (int i = 0; i < pattern.length(); i++) {
                char p = pattern.charAt(i);
                char w = s.charAt(i);

                if ((patternToWord.containsKey(p) && patternToWord.get(p) != w) || 
                    (wordTopattern.containsKey(w) && wordTopattern.get(w) != p)) {
                    match = false;
                    break;
                }

                patternToWord.put(p, w);
                wordTopattern.put(w, p);
            }

            if (match) result.add(s);
        }

        return result;
    }
}