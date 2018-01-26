class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        return dfs(nums, k, 0, sum / k, sum / k, 0, new boolean[nums.length]);
    }
    
    private boolean dfs(int[] nums, int k, int start, int target, int sum, int count, boolean[] visited) {
        if (k == 1) {
            return true;
        } else {
            if (target == 0 && count > 0) {
                return dfs(nums, k - 1, 0, sum, sum, 0, visited);
            } else {
                for (int i = start; i < nums.length; i++) {
                    if (!visited[i] && nums[i] <= target) {
                        visited[i] = true;
                        
                        if (dfs(nums, k, i + 1, target - nums[i], sum, count + 1, visited)) {
                            return true;
                        }
                        
                        visited[i] = false;
                    }
                }
                
                return false;
            }
        }
    }
}
