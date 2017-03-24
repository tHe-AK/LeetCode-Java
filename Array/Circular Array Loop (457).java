public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % n == 0) {
                nums[i] = 0;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int slow = i;
                int fast = i;
        
                while (isValid(nums, i, getIdx(nums, fast)) && isValid(nums, i, getIdx(nums, getIdx(nums, fast)))) {
                    slow = getIdx(nums, slow);
                    fast = getIdx(nums, getIdx(nums, fast));
                    
                    if (slow == fast) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private int getIdx(int[] nums, int i) {
        int n = nums.length;
        i = (i + nums[i]) % n;
        
        return i >= 0 ? i : n + i;
    }
    
    private boolean isValid(int[] nums, int i, int j) {
        return nums[j] != 0 && ((nums[i] ^ nums[j]) >> 31) == 0;
    }
}
