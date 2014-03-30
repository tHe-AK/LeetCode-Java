public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<String>();
        }
        
        ArrayList<String> result = new ArrayList<String>();
        helper(n, n, "", result);
        
        return result;
    }
    
    private void helper(int left, int right, String cur, ArrayList<String> result) {
        if (right == 0) {
            result.add(cur);
            return;
        }
        
        if (left > 0) {
            helper(left - 1, right, cur + '(', result);
        }
        if (right > left) {
            helper(left, right - 1, cur + ')', result);
        }
    }
}
