public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        long low = max;
        long high = sum;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isValid(nums, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return (int) low;
    }
    
    private boolean isValid(int[] nums, int m, long max) {
        long curr = 0;
        int count = 1;
        
        for (int num : nums) {
            curr += num;
            
            if (curr > max) {
                curr = num;
                count++;
                
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
