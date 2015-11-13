public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        if (prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        
        if (k >= len - 1) {
            return helper(prices);
        }
        
        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];
         
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
        
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        
        return global[len - 1][k];
    }
    
    private int helper(int[] prices) {
        int sum = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            
            if (diff > 0) {
                sum += diff;
            }
        }
        
        return sum;
    }
}
