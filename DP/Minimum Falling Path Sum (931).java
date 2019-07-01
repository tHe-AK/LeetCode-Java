class Solution {
    public int minFallingPathSum(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int val = A[i - 1][j];
                
                if (j > 0) {
                    val = Math.min(val, A[i - 1][j - 1]);
                }
                
                if (j < N - 1) {
                    val = Math.min(val, A[i - 1][j + 1]);
                }
                
                A[i][j] += val;
            }
        }
        
        for (int j = 0; j < N; j++) {
            min = Math.min(min, A[M - 1][j]);
        }
        
        return min;
    }
}
