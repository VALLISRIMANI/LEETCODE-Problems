class Solution {
    public List<String> commonChars(String[] words) {
        /*
        Map<Character, Integer> minFreq = new HashMap<>();

        for(char c : words[0].toCharArray()) {
            minFreq.put(c, minFreq.getOrDefault(c, 0) + 1);
        }

        for(int i = 1; i < words.length; i++) {
            Map<Character, Integer> curr = new HashMap<>();

            for(char c : words[i].toCharArray()) {
                curr.put(c, curr.getOrDefault(c, 0) + 1);
            }

            for(char ch : new HashSet<>(minFreq.keySet())) {
                minFreq.put(ch,
                    Math.min(minFreq.get(ch),
                            curr.getOrDefault(ch, 0)));

                if(minFreq.get(ch) == 0) {
                    minFreq.remove(ch);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : minFreq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }

        return result;
        */
        
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return ans;
    }
}