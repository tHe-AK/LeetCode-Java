public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        boolean[] flag = new boolean[num.length];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(new ArrayList<Integer>(), num, flag, result);
        
        return result;
    }
    
    private void helper(ArrayList<Integer> cur, int[] num, boolean[] flag, ArrayList<ArrayList<Integer>> result) {
        if (cur.size() == num.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                cur.add(num[i]);
                helper(cur, num, flag, result);
                flag[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
