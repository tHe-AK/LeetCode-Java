public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            while (sum >= s) {
                min = Math.min(min, i - start + 1);
                sum -= nums[start++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
