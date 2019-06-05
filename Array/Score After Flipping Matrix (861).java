class Solution {
    public int matrixScore(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int ans = M * (1 << (N - 1));
        
        for (int j = 1; j < N; j++) {
            int count = 0;
            
            for (int i = 0; i < M; i++) {
                count += A[i][0] == A[i][j] ? 1 : 0;
            }
            
            ans += Math.max(count, M - count) * (1 << (N - j - 1));
        }
        
        return ans;
    }
}
