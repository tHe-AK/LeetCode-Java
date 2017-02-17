public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] rec = new int[amount + 1];
        Arrays.fill(rec, amount + 1);
        rec[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int j = i - coin;
                
                if (j >= 0 && rec[j] <= amount) {
                    rec[i] = Math.min(rec[i], rec[j] + 1);
                }
            }
        }
        
        return rec[amount] <= amount ? rec[amount] : -1;
    }
}
