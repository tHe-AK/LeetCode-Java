public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        dfs(candidates, target, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] rec = new List[target + 1];
        
        for (int i = 0; i < rec.length; i++) {
            rec[i] = new ArrayList<>();
        }
        
        rec[0].add(new ArrayList<>());
        
        for (int candidate : candidates) {
            for (int i = candidate; i < rec.length; i++) {
                for (List<Integer> list : rec[i - candidate]) {
                    List<Integer> next = new ArrayList<>(list);
                    next.add(candidate);
                    rec[i].add(next);
                }
            }
        }
        
        return rec[target];
    }
}
