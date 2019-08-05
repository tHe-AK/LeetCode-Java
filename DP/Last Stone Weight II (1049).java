class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        
        for (int stone : stones) {
            sum += stone;
        }
        
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        
        for (int stone : stones) {
            for (int i = dp.length - 1; i - stone >= 0; i--) {
                dp[i] |= dp[i - stone];
            }
        }
        
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                return sum - i - i;
            }
        }
        
        return -1;
    }
}
