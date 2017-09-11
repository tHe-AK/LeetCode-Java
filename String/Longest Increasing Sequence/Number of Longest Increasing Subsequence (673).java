class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] ct = new int[n];
        int max = 0;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = ct[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        ct[i] = ct[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        ct[i] += ct[j];
                    }
                }   
            }
            
            if (dp[i] > max) {
                max = dp[i];
                res = ct[i];
            } else if (dp[i] == max) {
                res += ct[i];
            }
        }
        
        return res;
    }
}
