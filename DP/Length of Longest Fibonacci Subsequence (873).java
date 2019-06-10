class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < i; j++) {
                int k = map.getOrDefault(A[i] - A[j], -1);
                
                if (k >= 0 && k < j) {
                    dp[i][j] = dp[j][k] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
            
            map.put(A[i], i);
        }
        
        return max > 0 ? max + 2: 0;
    }
}
