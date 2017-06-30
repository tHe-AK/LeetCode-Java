public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            
            max = Math.max(max, i + nums[i]);
        }
        
        return true;
    }
}

public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len - 1];
    }
}
