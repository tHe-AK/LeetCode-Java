public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m > nums.length) {
            throw new IllegalArgumentException();
        }
        
        int max = nums[0];
        long sum = nums[0];
        
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
        long cur = 0;
        int count = 1;
        
        for (int num : nums) {
            cur += num;
            
            if (cur > max) {
                count++;
                cur = num;
                
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
