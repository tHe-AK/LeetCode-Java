public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        
        int diff = 0;
        
        for (int num : nums) {
            diff ^= num;
        }
        
        diff &= -diff;
        
        int[] result = new int[2];
        
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            }
            else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}
