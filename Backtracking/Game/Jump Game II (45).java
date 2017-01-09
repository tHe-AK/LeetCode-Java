public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int curr = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > curr) {
                step++;
                curr = max;
            }
            
            max = Math.max(max, i + nums[i]);
        }
        
        return step;
    }
}
