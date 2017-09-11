class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
