class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int N = A.length;
        int M = (int) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            map.put(A[i], i);
        }
        
        long[] dp = new long[N];
        Arrays.fill(dp, 1);
        long count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int val = A[i] / A[j];
                    
                    if (map.containsKey(val)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(val)]) % M;
                    }
                }
            }
            
            count = (count + dp[i]) % M;
        }
        
        return (int) count;
    }
}
