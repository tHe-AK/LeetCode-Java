public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for (int i = 1; i <= k; i++) {
            List<List<Integer>> next = new ArrayList<List<Integer>>();
            
            for (int j = 0; j < result.size(); j++) {
                for (int l = 1; l <= n; l++) {
                    List<Integer> cur = new ArrayList<Integer>(result.get(j));
                    
                    if (cur.size() > 0 && cur.get(cur.size() - 1) >= l) {
                        continue;
                    }
                    
                    cur.add(l);
                    next.add(cur);
                }
            }
            
            result = next;
        }
        
        return result;
    }
}

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        helper(n, k, 1, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int n, int k, int start, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            cur.add(i);
            helper(n, k, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}