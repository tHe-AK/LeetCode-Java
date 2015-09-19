public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int len = nums.length;
        int cur = 0;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        
        for (int i = cur; i < len; i++) {
            nums[i] = 0;
        }
    }
}
