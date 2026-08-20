class Solution {
    private static final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    public void backtrack(String digits, int idx, StringBuilder current,  List<String> result) {
        if (idx == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, idx + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}