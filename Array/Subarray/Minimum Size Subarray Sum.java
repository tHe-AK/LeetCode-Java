public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            while (start <= i && sum >= s) {
                min = Math.min(min, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
