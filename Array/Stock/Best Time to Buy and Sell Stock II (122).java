public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int price : prices) {
            min = Math.min(min, price - profit);
            profit = Math.max(profit, price - min);
        }
        
        return profit;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}
