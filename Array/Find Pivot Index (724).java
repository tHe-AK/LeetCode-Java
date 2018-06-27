class Solution {
    public int pivotIndex(int[] nums) {
        long sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < nums.length; i++) {            
            if (leftSum * 2 + nums[i] == sum) {
                return i;
            }
            
            leftSum += nums[i];
        }
        
        return -1;
    }
}
