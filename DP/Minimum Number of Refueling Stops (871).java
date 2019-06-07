class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        
        for (int i = 0; i < stations.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (stations[i][0] <= dp[j]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        
        return -1;
    }
}
