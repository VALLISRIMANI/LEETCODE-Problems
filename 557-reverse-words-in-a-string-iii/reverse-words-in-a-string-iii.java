class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        String str = "";
        for (int i = 0; i < words.length; i++) {
            str += reverse(words[i]);
            if (i != words.length - 1) {
                str += " ";
            }
        }
        return str;
    }

    public String reverse(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }

        return new String(arr);
    }
}