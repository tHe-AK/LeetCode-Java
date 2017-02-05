public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(n, 2, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    public void dfs(int n, int start, List<Integer> curr, List<List<Integer>> result){
        if (n <= 1) {
            if (curr.size() > 1) {
                result.add(new ArrayList<Integer>(curr));
            }
            
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                curr.add(i);
                dfs(n / i, i, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
