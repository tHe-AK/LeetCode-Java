public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        helper(n, n, "", result);
        
        return result;
    }
    
    private void helper(int left, int right, String pre, List<String> result) {
        if (right == 0) {
            result.add(pre);
            return;
        }
        
        if (left > 0) {
            helper(left - 1, right, pre + '(', result);
        }
        
        if (right > left) {
            helper(left, right - 1, pre + ')', result);
        }
    }
}
