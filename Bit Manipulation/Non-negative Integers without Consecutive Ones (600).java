public class Solution {
    public int findIntegers(int num) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int i = 30;
        int sum = 0;
        int prev = 0;
        
        while (i >= 0) {
            if (((num >>> i) & 1) == 1) {
                sum += dp[i];
                
                if (prev == 1) {
                    return sum;
                }
                
                prev = 1;
            } else {
                prev = 0;
            }
            
            i--;
        }
        
        return sum + 1;
    }
}
