public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        dfs(n, n, "", result);
        
        return result;
    }
    
    private void dfs(int left, int right, String pre, List<String> result) {
        if (right == 0) {
            result.add(pre);
            return;
        }
        
        if (left > 0) {
            dfs(left - 1, right, pre + '(', result);
        }
        
        if (right > left) {
            dfs(left, right - 1, pre + ')', result);
        }
    }
}
