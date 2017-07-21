public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (i >= k - 1) {
                max = Math.max(max, sum);
                sum -= nums[i - k + 1];
            }
        }
        
        return 1.0 * max / k;
    }
}
