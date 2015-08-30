public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        int cur = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cur ^= nums[i] ^ (i + 1);
        }
        
        return cur;
    }
}
