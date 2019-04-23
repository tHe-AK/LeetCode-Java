class Solution {
    public double soupServings(int N) {
        N = (N + 24) / 25;
        
        if (N >= 200) {
            return 1;
        }
        
        return dfs(N, N, 1, new Double[N + 1][N + 1]);
    }
    
    private double dfs(int A, int B, double prob, Double[][] memo) {
        if (A <= 0 && B <= 0) {
            return prob / 2;
        } else if (A <= 0) {
            return prob;
        } else if (B <= 0) {
            return 0;
        } else if (memo[A][B] != null) {
            return memo[A][B];
        } else {
            prob /= 4;
            memo[A][B] = dfs(A - 4, B, prob, memo) + dfs(A - 3, B - 1, prob, memo) + dfs(A - 2, B - 2, prob, memo) + dfs(A - 1, B - 3, prob, memo);
            return memo[A][B];
        }
    }
}
