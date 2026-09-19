class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String[] words = paragraph.toLowerCase().split("[^a-z]+");

        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        int maxFreq = 0;
        String result = "";

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                result = e.getKey();
            }
        }

        return result;
    }
}