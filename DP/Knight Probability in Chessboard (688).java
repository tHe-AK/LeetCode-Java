class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] delta = { { -2, -1 }, { -1, -2, }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1} };
        double[][] dp = new double[N][N];
        
        for (double[] row : dp) {
            Arrays.fill(row, 1);
        }
        
        for (int k = 0; k < K; k++) {
            double[][] temp = new double[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] diff : delta) {
                        int x = i + diff[0];
                        int y = j + diff[1];
                        
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            temp[i][j] += dp[x][y] / 8;
                        }
                    }
                }
            }
            
            dp = temp;
        }
        
        return dp[r][c];
    }
}
