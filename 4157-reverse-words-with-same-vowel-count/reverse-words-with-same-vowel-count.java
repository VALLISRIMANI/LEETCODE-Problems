class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        sb.append(words[0]);
        int countOfVowels = vowelsCount(words[0]);

        for (int i = 1; i < words.length; i++) {
            sb.append(" ");
            if (countOfVowels == vowelsCount(words[i])) {
                sb.append(reverse(words[i]));
            } else {
                sb.append(words[i]);
            }
        }

        return sb.toString();
    }

    private static int vowelsCount(String word) {
        String vowels = new String("aeiou");
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                count++;
            }
        }

        return count;
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1; 

        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(chars);
    }
}