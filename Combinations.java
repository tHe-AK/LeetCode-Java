public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1 || k > n) {
            return null;
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(n, k, 1, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int n, int k, int start, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(n, k, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
