public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(k, n, 1, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int k, int n, int start, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(curr));
            }
            
            return;
        }
        
        for (int i = start; i <= 9 && i <= n; i++) {
            curr.add(i);
            dfs(k, n - i, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>[] rec = new List[n + 1];
        
        for (int i = 0; i < rec.length; i++) {
            rec[i] = new ArrayList<>();
        }
        
        rec[0].add(new ArrayList<>());
        
        for (int i = 1; i <= 9; i++) {
            for (int j = rec.length - 1; j >= i; j--) {
                for (List<Integer> list : rec[j - i]) {
                    if (list.size() < k) {
                        List<Integer> next = new ArrayList<>(list);
                        next.add(i);
                        rec[j].add(next);
                    }
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (List<Integer> list : rec[n]) {
            if (list.size() == k) {
                result.add(list);
            }
        }
        
        return result;
    }
}
