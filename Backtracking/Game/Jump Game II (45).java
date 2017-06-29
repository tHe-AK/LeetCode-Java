public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int curr = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > curr) {
                step++;
                curr = max;
            }
            
            max = Math.max(max, i + nums[i]);
        }
        
        return step;
    }
}

public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[len - 1];
    }
}
