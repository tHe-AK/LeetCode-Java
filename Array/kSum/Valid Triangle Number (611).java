public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        
        for (int i = len - 1; i >= 2; i--) {
            int low = 0;
            int high = i - 1;
            
            while (low < high) {
                if (nums[low] + nums[high] > nums[i]) {
                    count += high - low;
                    high--;
                } else {
                    low++;
                }
            }
        }
        
        return count;
    }
}
