class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int N = 365;
        int[] dp = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i : days) {
            visited[i] = true;
        }
        
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        
        return dp[N];
    }
}
