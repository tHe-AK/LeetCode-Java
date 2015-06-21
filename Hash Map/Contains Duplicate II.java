public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k < 1) {
            return false;
        }
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            if (hashSet.contains(cur)) {
                return true;
            }
            
            hashSet.add(cur);
            
            if (i >= k) {
                hashSet.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}
