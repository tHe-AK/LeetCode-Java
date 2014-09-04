public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(num, new boolean[num.length], new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, boolean[] flag, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == num.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (flag[i] == true || (i != 0 && num[i] == num[i - 1] && rec[i - 1] == false)) {
                continue;
            }
            
            flag[i] = true;
            cur.add(num[i]);
            helper(num, flag, cur, result);
            flag[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
