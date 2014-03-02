public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(new ArrayList<Integer>(), k, 1, n, result);
        
        return result;
    }
    
    private void helper(ArrayList<Integer> cur, int k, int index, int n, ArrayList<ArrayList<Integer>> result) {
        if (cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = index; i <= n; i++) {
            cur.add(i);
            helper(cur, k, i + 1, n, result);
            cur.remove(cur.size() - 1);
        }
    }
}
