public class Solution {
    public int maxProfit(int[] prices, int count) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        
        if (prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[][] rec = new int[len][len];
        int[][] result = new int[count][len];
        
        for (int i = 0; i < len; i++) {
            int low = prices[i];
            
            for (int j = i + 1; j < len; j++) {
                rec[i][j] = Math.max(rec[i][j - 1], prices[j] - low);
                low = Math.min(low, prices[j]);
            }
        }
        
        for (int i = 0; i < count; i++) {
            for (int j = i; j < len; j++) {
                if (i == 0) {
                    result[i][j] = rec[0][j];
                }
                else {
                    int profit = 0;
                    
                    for (int k = 0; k <= j; k++) {
                        profit = Math.max(profit, result[i - 1][k] + rec[k][j]);
                    }
                    
                    result[i][j] = profit;
                }
            }
        }
        
        return result[count - 1][len - 1];
    }
}
