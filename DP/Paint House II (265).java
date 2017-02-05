public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                    
                for (int x = 0; x < k; x++) {
                    if (x != j) {
                        min = Math.min(min, costs[i - 1][x]);
                    }
                }
                    
                costs[i][j] += min;
            }
        }
        
        int min = Integer.MAX_VALUE;
                    
        for (int j = 0; j < k; j++) {
            min = Math.min(min, costs[n - 1][j]);
        }
        
        return min;
    }
}
