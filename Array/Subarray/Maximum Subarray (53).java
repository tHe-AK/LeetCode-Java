public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < len; i++) {
            max = Math.max(max + rec[i], rec[i]);
            result = Math.max(result, max);
        }
        
        return result;
    }
}
