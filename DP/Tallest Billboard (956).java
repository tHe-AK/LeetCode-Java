class Solution {
    public int tallestBillboard(int[] rods) {
        int N = 5000;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int rod : rods) {
            int[] next = dp.clone();
            
            for (int i = 0; i + rod <= N; i++) {
                next[i + rod] = Math.max(next[i + rod], dp[i]);
                next[Math.abs(i - rod)] = Math.max(next[Math.abs(i - rod)], dp[i] + Math.min(i, rod));
            }
            
            dp = next;
        }
        
        return dp[0];
    }
}
