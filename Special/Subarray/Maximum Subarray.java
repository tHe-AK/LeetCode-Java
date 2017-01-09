public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] rec = new int[len];
        rec[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < len; i++) {
            rec[i] = Math.max(rec[i - 1] + nums[i], nums[i]);
            max = Math.max(max, rec[i]);
        }
        
        return max;
    }
}
