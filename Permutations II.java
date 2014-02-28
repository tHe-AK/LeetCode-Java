public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        int len = num.length;
        Arrays.sort(num);
        boolean[] rec = new boolean[len];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(new ArrayList<Integer>(), num, rec, result);
        
        return result;
    }
    
    private void helper(ArrayList<Integer> cur, int[] num, boolean[] rec, ArrayList<ArrayList<Integer>> result) {
        if (cur.size() == num.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (rec[i] == true || (i != 0 && num[i] == num[i - 1] && rec[i - 1] == false)) {
                continue;
            }
            rec[i] = true;
            cur.add(num[i]);
            helper(cur, num, rec, result);
            rec[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
