class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lenP = p.length();
        int lenS = s.length();

        if (lenS < lenP) return result;

        int[] freq = new int[26];
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        int left = 0, right = 0, count = lenP;

        while (right < lenS) {
            char ch = s.charAt(right);

            if (freq[ch - 'a'] > 0) {
                count--;
            }

            freq[ch - 'a']--;
            right++;

            if (right - left > lenP) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']++;

                if (freq[leftChar - 'a'] > 0) {
                    count++;
                }

                left++;
            }

            if (count == 0) {
                result.add(left);
            }
        }

        return result;
    }
}