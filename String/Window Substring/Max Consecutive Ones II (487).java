public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        
        while (end < nums.length) {
            if (nums[end++] == 0) {
                count++;
            }

            while (count > 1) {
                if (nums[start++] == 0) {
                    count--;
                }
            }
            
            result = Math.max(result, end - start);
        }
        
        return result;
    }
}
