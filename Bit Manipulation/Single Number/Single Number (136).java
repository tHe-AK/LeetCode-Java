public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        
        for (int num : nums) {
            one ^= num;
        }
        
        return one;
    }
}
