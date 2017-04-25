public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        if (len == 0) {
            return res;
        }
        
        res[0] = 1;
        int product = 1;
        
        for (int i = 1; i < len; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        
        for (int i = len - 2; i >= 0; i--) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        
        return res;
    }
}
