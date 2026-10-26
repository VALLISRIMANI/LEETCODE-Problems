class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if (k > s2.length()) return false;

        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            freqMap1.put(ch, freqMap1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char ch = s2.charAt(i);
            freqMap2.put(ch, freqMap2.getOrDefault(ch, 0) + 1);
        }

        if (freqMap1.equals(freqMap2)) return true;

        for (int i = k; i < s2.length(); i++) {
            char ch1 = s2.charAt(i - k);
            freqMap2.put(ch1, freqMap2.get(ch1) - 1);
            if (freqMap2.get(ch1) == 0) {
                freqMap2.remove(ch1);
            }

            char ch2 = s2.charAt(i);
            freqMap2.put(ch2, freqMap2.getOrDefault(ch2, 0) + 1);

            if (freqMap1.equals(freqMap2)) return true;
        }

        return false;
    }
}