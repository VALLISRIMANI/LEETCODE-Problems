class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", num, target, 0, 0, 0);
        Collections.sort(result);
        return result;
    }
    
    private void backtrack(List<String> result, String path, String s, int target, int index, long eval, long prevOperand) {
        if (index == s.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(index) == '0') break;
            
            String currStr = s.substring(index, i + 1);
            long currNum = Long.parseLong(currStr);
            
            if (index == 0) {
                backtrack(result, currStr, s, target, i + 1, currNum, currNum); 
            } else {
                backtrack(result, path + "+" + currStr, s, target, i + 1, eval + currNum, currNum);
                backtrack(result, path + "-" + currStr, s, target, i + 1, eval - currNum, -currNum);
                backtrack(result, path + "*" + currStr, s, target, i + 1,
                          eval - prevOperand + prevOperand * currNum,
                          prevOperand * currNum);
            }
        }
    }
}