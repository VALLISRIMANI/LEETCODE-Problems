class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minColors = Integer.MAX_VALUE;
        int whiteColors = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteColors++;
            }
        }
        
        minColors = Math.min(minColors, whiteColors);

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') whiteColors--;
            if (blocks.charAt(i) == 'W') whiteColors++;
            
            minColors = Math.min(minColors, whiteColors);
        }

        return minColors;
    }
}