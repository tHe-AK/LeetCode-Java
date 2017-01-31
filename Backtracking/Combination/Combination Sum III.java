public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (k < 1 || n < 1) {
            return result;
        }
        
        helper(1, k, n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int start, int k, int n, List<Integer> cur, List<List<Integer>> result) {
        if (n < 0) {
            return;
        }
        
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(cur));
            }
            
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            helper(i + 1, k - 1, n - i, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
