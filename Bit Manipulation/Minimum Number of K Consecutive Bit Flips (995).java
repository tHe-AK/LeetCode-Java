class Solution {
    public int minKBitFlips(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N];
        int flipped = 0;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (A[i] == flipped) {
                if (i + K > N) {
                    return -1;
                }
                
                flipped ^= 1;
                dp[i] = 1;
                count++;
            }
            
            if (i >= K - 1) {
                flipped ^= dp[i - K + 1];
            }
        }
        
        return count;
    }
}

class Solution {
    public int minKBitFlips(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N];
        int flipped = 0;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (flipped % 2 == A[i]) {
                if (i + K > N) {
                    return -1;
                }
                
                flipped++;
                dp[i] = 1;
                count++;
            }
            
            if (i >= K - 1) {
                flipped -= dp[i - K + 1];
            }
        }
        
        return count;
    }
}
