public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        
        HashSet<Integer> hashSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            if (hashSet.contains(cur)) {
                return true;
            }
            
            hashSet.add(cur);
        }
        
        return false;
    }
}
