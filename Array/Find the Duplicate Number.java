public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        
        int slow = 0;
        int fast = 0;
        int len = nums.length;
        boolean cycle = false;
        
        while (slow >= 0 && slow < len && fast >= 0 && fast < len) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        
        if (!cycle) {
            throw new IllegalArgumentException();
        }
        
        slow = 0;
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
