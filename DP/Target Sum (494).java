public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        return (sum < S || (sum + S) % 2 != 0) ? 0 : subsetSum(nums, (sum + S) / 2); 
    }   

    private int subsetSum(int[] nums, int S) {
        int[] dp = new int[S + 1]; 
        dp[0] = 1;
        
        for (int num : nums) {
            for (int i = S; i >= num; i--) {
                dp[i] += dp[i - num]; 
            }
        }
        
        return dp[S];
    } 
}
