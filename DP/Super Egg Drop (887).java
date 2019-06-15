class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        
        for (int i = 1; i <= N; i++) {
            dp[i][1] = i;
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = i;

                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }                
            }
        }
        
        return dp[N][K];
    }
}

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        return helper(N, K, dp);
    }
    
    private int helper(int N, int K, int[][] dp) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        
        if (dp[N][K] > 0) {
            return dp[N][K];
        }
        
        dp[N][K] = N;
        
        for (int i = 1; i <= N; i++) {
            int left = helper(i - 1, K - 1, dp);
            int right = helper(N - i, K, dp);
            dp[N][K] = Math.min(dp[N][K], Math.max(left, right) + 1);
        }
        
        return dp[N][K];
    }
}

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        return binarySearch(N, K, dp);
    }
    
    private int binarySearch(int N, int K, int[][] dp) {
        if (K == 0 || N == 0) {
            return 0;
        }
        
        if (K == 1) {
            return N;
        }
        
        if (dp[N][K] > 0) {
            return dp[N][K];
        }
        
        int low = 1;
        int high = N;
        dp[N][K] = N;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = binarySearch(mid - 1, K - 1, dp);
            int right = binarySearch(N - mid, K, dp);
            dp[N][K] = Math.min(dp[N][K], Math.max(left, right) + 1);
            
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return dp[N][K];
    }
}

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int i = 0;
        
        while (dp[i][K] < N) {
            i++;
            
            for (int k = 1; k <= K; k++) {
                dp[i][k] = dp[i - 1][k - 1] + dp[i - 1][k] + 1;
            }
        }
        
        return i;
    }
}

class Solution {
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int i = 0;
        
        while (dp[K] < N) {
            i++;
            
            for (int k = K; k >= 1; k--) {
                dp[k] += dp[k - 1] + 1;
            }
        }
        
        return i;
    }
}
