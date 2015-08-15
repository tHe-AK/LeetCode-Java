public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        if (nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] result = new int[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            result[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            
            max = Math.max(max, result[i]);
        }
        
        return max;
    }
}

