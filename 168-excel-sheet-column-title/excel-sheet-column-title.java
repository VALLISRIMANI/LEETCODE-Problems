class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int num = columnNumber;
        while (num > 0) {
            num--;
            sb.append((char) ((num % 26) + 'A'));
            num /= 26;
        }        

        return sb.reverse().toString();
    }
}