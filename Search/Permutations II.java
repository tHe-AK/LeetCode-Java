public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(num);
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
            if (i != 0 && num[i] == num[i - 1] && !rec[i - 1]) {
                continue;
            }
            
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