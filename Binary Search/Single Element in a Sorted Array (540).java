public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length / 2;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid * 2] != nums[mid * 2 + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return nums[low * 2];
    }
}
