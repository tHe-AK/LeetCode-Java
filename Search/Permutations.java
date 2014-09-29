public class Solution {
    public List<List<Integer>> permute(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(num, new boolean[num.length], new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] num, boolean[] rec, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == num.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (!rec[i]) {
                rec[i] = true;
                cur.add(num[i]);
                helper(num, rec, cur, result);
                rec[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}