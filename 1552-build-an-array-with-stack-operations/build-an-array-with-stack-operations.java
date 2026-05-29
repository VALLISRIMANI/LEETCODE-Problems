class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int j = 0; 
        
        for (int num = 1; num <= n && j < target.length; num++) {
            ops.add("Push");
            if (num == target[j]) {
                j++; 
            } else {
                ops.add("Pop"); 
            }
        }
        
        return ops;
    }
}