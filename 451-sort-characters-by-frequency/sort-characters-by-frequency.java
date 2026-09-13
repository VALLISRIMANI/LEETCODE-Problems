class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(freq.keySet());
        Collections.sort(chars, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);

            if (fa != fb) {
                return fb - fa;
            }

            return fa - fb;
        });

        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            int frequency = freq.get(ch);

            for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}