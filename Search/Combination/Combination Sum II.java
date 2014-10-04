public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        helper(num, target, 0, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, int target, int start, List<Integer> cur, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            
            cur.add(num[i]);
            helper(num, target - num[i], i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}