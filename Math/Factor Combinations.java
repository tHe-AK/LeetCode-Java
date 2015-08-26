public class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(n, 2, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int n, int start, List<Integer> cur, List<List<Integer>> result) {
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                cur.add(i);
                cur.add(n / i);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
                helper(n / i, i, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
