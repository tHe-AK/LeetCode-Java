public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = nums.length;
        
        if (size == 1) {
            return nums[0];
        }
        
        int[] rec = new int[size + 1];
        rec[0] = 0;
        rec[1] = nums[0];
        
        for (int i = 2; i < size; i++) {
            rec[i] = Math.max(rec[i - 2] + nums[i - 1], rec[i - 1]);
        }
        
        int max = rec[size - 1];
        
        rec[1] = 0;
        rec[2] = nums[1];
        
        for (int i = 3; i <= size; i++) {
            rec[i] = Math.max(rec[i - 2] + nums[i - 1], rec[i - 1]);
        }
        
        return Math.max(max, rec[size]);
    }
}
