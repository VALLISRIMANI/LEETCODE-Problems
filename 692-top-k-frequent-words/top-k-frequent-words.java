class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> temp = new ArrayList<>(map.keySet());
        Collections.sort(temp, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if (freqA != freqB) {
                return freqB - freqA;
            }

            return a.compareTo(b);
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(temp.get(i));
        }

        return result;
    }
}