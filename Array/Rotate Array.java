public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException();
        }
        
        int len = nums.length;
        
        if (len <= 1) {
            return;
        }
        
        k %= len;
        
        if (k == 0) {
            return;
        }
        
        helper(nums, 0, len - k - 1);
        helper(nums, len - k, len - 1);
        helper(nums, 0, len - 1);
        
        return;
    }
    
    private void helper(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}