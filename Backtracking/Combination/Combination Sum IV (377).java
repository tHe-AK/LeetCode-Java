public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int k = i - nums[j];
                
                if (k >= 0) {
                    dp[i] += dp[k];
                }
            }
        }
        
        return dp[target];
    }
}

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        
        return dfs(nums, target, dp);
    }
    
    private int dfs(int[] nums, int target, int[] dp) {
        if (dp[target] >= 0) {
            return dp[target];
        }
        
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                count += dfs(nums, target - nums[i], dp);
            }
        }
        
        dp[target] = count;
        
        return count;
    }
}

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                count += combinationSum4(nums, target - nums[i]);
            }
        }
        
        return count;
    }
}
