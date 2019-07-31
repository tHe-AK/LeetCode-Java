class Solution {
    public int longestArithSeqLength(int[] A) {
        int N = A.length;
        int res = 0;
        Map<Integer, Integer>[] dp = new Map[N];
        
        for (int i = 0; i < N; i++) {
            dp[i] = new HashMap<>();
            
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int count = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, count);
                res = Math.max(res, count);
            }
        }
        
        return res;
    }
}
