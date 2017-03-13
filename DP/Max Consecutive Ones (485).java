public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;

        for (int num : nums) {
            curr = num == 0 ? 0 : curr + 1;
            max = Math.max(max, curr);
        }
            
        return max; 
    }
}
