class Solution {
    public String findValidPair(String s) {
        int n = s.length();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            int val = ch - '0';
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int i = 0; i < n - 1; i++) {
            int val1 = s.charAt(i) - '0';
            int val2 = s.charAt(i + 1) - '0';
            if (val1 != val2 && map.get(val1) == val1 && map.get(val2) == val2) {
                return s.substring(i, i + 2);
            }
        }

        return "";
    }
}