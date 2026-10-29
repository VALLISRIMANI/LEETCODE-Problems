class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = Integer.MIN_VALUE;
        int vowels = 0;

        for (int i = 0; i < k; i++) {
            if("aeiou".indexOf(s.charAt(i)) != -1) {
                vowels++;
            }
        }

        maxVowels = Math.max(maxVowels, vowels);

        for (int i = k; i < s.length(); i++) {
            if("aeiou".indexOf(s.charAt(i - k)) != -1) {
                vowels--;
            }

            if("aeiou".indexOf(s.charAt(i)) != -1) {
                vowels++;
            }

            maxVowels = Math.max(maxVowels, vowels);
        }

        return maxVowels;
    }
}