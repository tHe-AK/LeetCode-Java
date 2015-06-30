public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int low = 0;
        int high = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while (low <= high && high < nums.length) {
            while (high < nums.length && sum < s) {
                sum += nums[high];
                high++;
            }
            
            while (low <= high && sum >= s) {
                min = Math.min(min, high - low);
                sum -= nums[low];
                low++;
            }
        }
        
        return min != Integer.MAX_VALUE ? min : 0;
    }
}