class Solution {
    public String clearDigits(String s) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                answer.setLength(answer.length() - 1);
            } else {
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }
}