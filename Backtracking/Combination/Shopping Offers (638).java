public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
        int min = 0;
        
        for (int i = 0; i < needs.size(); i++) {
            min += needs.get(i) * price.get(i);
        }
        
        while (start < special.size()) {
            List<Integer> curr = special.get(start);
            List<Integer> next = new ArrayList<>(needs);
            int i = 0;
            int n = curr.size();
            
            while (i < n - 1) {
                int val = needs.get(i) - curr.get(i);
                
                if (val < 0) {
                    break;
                }
                
                next.set(i, val);
                i++;
            }
            
            if (i == n - 1) {
                min = Math.min(min, curr.get(n - 1) + dfs(price, special, next, start));
            }
            
            start++;
        }
        
        return min;
    }
}
