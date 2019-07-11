class Solution {
    public int tallestBillboard(int[] rods) {
        int N = 5000;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int rod : rods) {
            int[] next = dp.clone();
            
            for (int i = 0; i + rod <= N; i++) {
                if (dp[i] >= 0) {
                    next[i + rod] = Math.max(next[i + rod], dp[i]);
                    next[Math.abs(i - rod)] = Math.max(next[Math.abs(i - rod)], dp[i] + Math.min(i, rod));
                }
            }
            
            dp = next;
        }
        
        return dp[0];
    }
}

class Solution {
    public int tallestBillboard(int[] rods) {
        int N = 5000;
        int[] dp = new int[2 * N + 1];
        Arrays.fill(dp, -1);
        dp[N] = 0;
        
        for (int rod : rods) {
            int[] next = dp.clone();
            
            for (int i = 0; i <= 2 * N; i++) {
                if (dp[i] >= 0) {
                    if (i + rod <= 2 * N) {
                        next[i + rod] = Math.max(next[i + rod], dp[i] + rod);
                    }
                    
                    if (i - rod >= 0) {
                        next[i - rod] = Math.max(next[i - rod], dp[i]);
                    }
                }
            }
            
            dp = next;
        }
        
        return dp[N];
    }
}
