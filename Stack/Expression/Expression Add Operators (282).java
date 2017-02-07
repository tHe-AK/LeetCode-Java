public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        
        dfs(num, target, 0, 0, 0, "", result);
        
        return result;
    }
    
    private void dfs(String num, int target, int start, long val, long prev, String str, List<String> result) {
        if (start == num.length()) {
            if (val == target) {
                result.add(str);
            }
            
            return;
        }
        
        for (int end = start + 1; end <= num.length(); end++) {
            if (end > start + 1 && num.charAt(start) == '0') {
                break;
            }
            
            long curr = Long.parseLong(num.substring(start, end));
            
            if (start == 0) {
                dfs(num, target, end, curr, curr, str + curr, result);
            } else {
                dfs(num, target, end, val + curr, curr, str + "+" + curr, result);
                dfs(num, target, end, val - curr, -curr, str + "-" + curr, result);
                dfs(num, target, end, val - prev + prev * curr, prev * curr, str + "*" + curr, result);
            }
        }
    }
}
