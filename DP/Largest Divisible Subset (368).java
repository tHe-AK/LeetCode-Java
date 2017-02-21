public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] path = new int[n];
        int max = 0;
        int idx = -1;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            path[i] = -1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    path[i] = j;
                }
            }
            
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        
        while (idx != -1) {
            result.add(nums[idx]);
            idx = path[idx];
        }
        
        Collections.reverse(result);
        
        return result;
    }
}
