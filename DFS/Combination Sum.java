public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(candidates, target - candidates[i], i, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}