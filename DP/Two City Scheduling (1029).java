class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length;
        int sum = 0;
        Arrays.sort(costs, (a, b) -> Integer.compare(a[0] - b[0], a[1] - b[1]));

        for (int i = 0; i < N / 2; i++) {
            sum += costs[i][0] + costs[N - i - 1][1];
        }
        
        return sum;
    }
}

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + costs[i + j - 1][1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + costs[i + j - 1][0];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + costs[i + j - 1][1], dp[i - 1][j] + costs[i + j - 1][0]);
                }
            }
        }
        
        return dp[N][N];
    }
}

