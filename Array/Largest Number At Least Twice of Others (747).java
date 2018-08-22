class Solution {
    public int dominantIndex(int[] nums) {
        int first = nums[0];
        int idx = 0;
        int second = -1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= first) {
                second = first;
                first = nums[i];
                idx = i;
            } else if (nums[i] >= second) {
                second = nums[i];
            }
        }
        
        return (second == -1 || first >= second * 2) ? idx : -1; 
    }
}
