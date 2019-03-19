class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        int[] dp = new int[N + 1];
        dp[0] = 1;
        // 0 for not valid
        // 1 for unchanged
        // 2 for valid
        
        for (int i = 1; i <= N; i++) {
            int digit = i % 10;
            int val = dp[i / 10];

            if (digit == 0 || digit == 1 || digit == 8) {
                if (val >= 1) {
                    dp[i] = val;
                }
            } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                if (val >= 1) {
                    dp[i] = 2;
                }
            }
            
            if (dp[i] == 2) {
                count++;
            }
        }
        
        return count;
    }
}
