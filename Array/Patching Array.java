public class Solution {
    public int minPatches(int[] nums, int n) {
        if (nums == null || n < 1) {
            throw new IllegalArgumentException();
        }
        
        long miss = 1;
        int count = 0;
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                count++;
                miss += miss;
            }
        }
        
        return count;
    }
}
