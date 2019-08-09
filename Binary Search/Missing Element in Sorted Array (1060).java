class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int missing = nums[high] - nums[0] - high;
        
        if (k > missing) {
            return nums[high] + k - missing;
        }

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            missing = nums[mid] - nums[low] - (mid - low);
            
            if (missing >= k) {
                high = mid;
            } else {
                k -= missing;
                low = mid;
            }
        }
        
        return nums[low] + k;
    }
}

class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = nums[mid] - nums[0] - mid;
            
            if (missing >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return nums[0] + high + k;
    }
}
