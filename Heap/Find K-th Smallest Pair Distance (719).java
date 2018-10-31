class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(nums, mid);
            
            if (k <= count) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private int getCount(int[] nums, int max) {
        int start = 0;
        int count = 0;
        
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] - nums[start] > max) {
                start++;
            }
            
            count += i - start;
        }
        
        return count;
    }
}
