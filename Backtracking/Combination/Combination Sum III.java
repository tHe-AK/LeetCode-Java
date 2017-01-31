public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(k, n, 1, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int k, int n, int start, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(curr));
            }
            
            return;
        }
        
        for (int i = start; i <= 9 && i <= n; i++) {
            curr.add(i);
            dfs(k, n - i, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
