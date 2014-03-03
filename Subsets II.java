public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }
        
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(new ArrayList<Integer>(), 0, num, result);
        
        return result;
    }
    
    private void helper(ArrayList<Integer> cur, int index, int[] num, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(cur));
        
        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            cur.add(num[i]);
            helper(cur, i + 1, num, result);
            cur.remove(cur.size() - 1);
        }
    }
}
