public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null) {
            throw new IllegalArgumentException();
        }
        
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i > 0) {
                    min = Integer.MAX_VALUE;
                    
                    for (int x = 0; x < k; x++) {
                        if (x != j) {
                            min = Math.min(min, costs[i - 1][x]);
                        }
                    }
                    
                    costs[i][j] += min;
                }
            }
        }
        
        min = Integer.MAX_VALUE;
                    
        for (int j = 0; j < k; j++) {
            min = Math.min(min, costs[n - 1][j]);
        }
        
        return min;
    }
}
