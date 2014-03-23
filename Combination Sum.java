public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(target, new ArrayList<Integer>(), 0, candidates, result);
        
        return result;
    }
    
    private void helper(int target, ArrayList<Integer> cur, int index, int[] candidates, ArrayList<ArrayList<Integer>> result) {
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            helper(target - candidates[i], cur, i, candidates, result);
            cur.remove(cur.size() - 1);
        }
    }
}
