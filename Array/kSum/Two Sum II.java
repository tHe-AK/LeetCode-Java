public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(nums);
        int count = 0;
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            if (nums[low] + nums[high] > target) {
                count += high - low;
                high--;
            } else {
                low++;
            }
        }
        
        return count;
    }
}
