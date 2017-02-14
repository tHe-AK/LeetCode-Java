public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;
        
        for (int price : prices) {
            min = Math.min(min, price - profit1);
            profit1 = profit2;
            profit2 = Math.max(profit2, price - min);
        }
        
        return profit2;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[] min = new int[len + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[1] = prices[0];
        int[] profit = new int[len + 1];
        
        for (int i = 1; i <= len; i++) {
            min[i] = Math.min(min[i - 1], prices[i - 1] - profit[i - 2]);
            profit[i] = Math.max(profit[i - 1], prices[i - 1] - min[i]);
        }
        
        return profit[len];
    }
}
