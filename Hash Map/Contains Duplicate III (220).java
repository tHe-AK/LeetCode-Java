public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            
            if (ceiling != null && nums[i] >= ceiling - t) {
                return true;
            }
    
            Integer floor = set.floor(nums[i]);
            
            if (floor != null && nums[i] <= floor + t) {
                return true;
            }
    
            set.add(nums[i]);
            
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}
