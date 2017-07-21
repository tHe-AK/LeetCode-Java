public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double high = Integer.MIN_VALUE;
        double low = Integer.MAX_VALUE;
        double delta = 0.00001;

        for (int num : nums) {
            high = Math.max(high, num);
            low = Math.min(low, num);
        }
        
        while (high - low > delta) {
            double mid = low + (high - low) / 2;
            
            if (isValid(nums, mid, k)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private boolean isValid(int[] nums, double mid, int k) {
        double curr = 0;
        double pre = 0;
        
        for (int i = 0; i < k; i++) {
            curr += nums[i] - mid;
        }
        
        if (curr >= 0) {
            return true;
        }
        
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - mid;
            double val = nums[i - k] - mid;
            curr -= val;
            pre = Math.max(pre + val, val);
            
            if (Math.max(pre + curr, curr) >= 0) {
                return true;
            } 
        }
        
        return false;
    }
}
