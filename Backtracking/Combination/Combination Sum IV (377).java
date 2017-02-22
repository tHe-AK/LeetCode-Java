public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        
        int count = 0;
        
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            count += combinationSum4(nums, target - nums[i]);
        }
        
        return count;
    }
}
