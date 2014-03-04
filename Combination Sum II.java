public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0 || target < 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(target, 0, new ArrayList<Integer>(), num, result);
        
        return result;
    }
    
    private void helper(int target, int index, ArrayList<Integer> cur, int[] num, ArrayList<ArrayList<Integer>> result) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            cur.add(num[i]);
            helper(target - num[i], i + 1, cur, num, result);
            cur.remove(cur.size() - 1);
        }
    }
}
