class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() < 10) return result;

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

        for (int i = 10; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}