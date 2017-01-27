public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }
        
        int[] rec = new int[len + 1];
        rec[0] = 0;
        rec[1] = nums[0];
        
        for (int i = 2; i <= len; i++) {
            rec[i] = Math.max(rec[i - 2] + nums[i - 1], rec[i - 1]);
        }
        
        return rec[len];
    }
}
