class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childrens = g.length, cookies = s.length;
        int child = 0, cookie = 0;

        while (child < childrens && cookie < cookies) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }

        return child;
    }
}