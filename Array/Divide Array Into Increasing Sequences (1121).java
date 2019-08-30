class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int count = 1;
        int max = 1;
        
        for (int i = 1; i < nums.length; i++) {
            count = nums[i - 1] < nums[i] ? 1 : count + 1;
            max = Math.max(max, count);
        }
        
        return max * K <= nums.length;
    }
}
