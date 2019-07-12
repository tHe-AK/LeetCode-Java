class Solution {
    public int minDeletionSize(String[] A) {
        int N = A[0].length();
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            search: for (int j = 0; j < i; j++) {
                for (String row: A) {
                    if (row.charAt(j) > row.charAt(i)) {
                        continue search;
                    }
                }

                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
            max = Math.max(max, dp[i]);
        }

        return N - max;
    }
}
