public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else {
            return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
        }
    }
    
    private int rob(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prevMax + nums[i], currMax);
            prevMax = currMax;
            currMax = temp;
        }
        
        return currMax;
    }
}
