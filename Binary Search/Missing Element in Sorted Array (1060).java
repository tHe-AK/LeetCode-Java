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
