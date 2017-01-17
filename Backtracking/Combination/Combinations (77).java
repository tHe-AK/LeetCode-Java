public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(n, k, 1, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int n, int k, int start, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            curr.add(i);
            dfs(n, k, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
