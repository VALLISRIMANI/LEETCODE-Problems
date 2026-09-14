class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        int n = s.length();
        
        if (n == 0) return s;
        int firstGroupLen = n % k == 0 ? k : n % k;
        StringBuilder sb = new StringBuilder();
        
        sb.append(s.substring(0, firstGroupLen));
        
        for (int i = firstGroupLen; i < n; i += k) {
            sb.append("-");
            sb.append(s.substring(i, i + k));
        }
        
        return sb.toString();
    }
}