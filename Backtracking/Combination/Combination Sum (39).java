public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        dfs(candidates, target, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            curr.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
