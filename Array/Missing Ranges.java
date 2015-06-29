public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        
        if (nums == null) {
            return result;
        }
        
        for (int i = 0; i <= nums.length; i++) {
            int cur = (i == nums.length) ? upper + 1 : nums[i];
            
            if (cur > lower) {
                result.add(helper(lower, cur - 1));
            }
            
            lower = cur + 1;
        }

        return result;
    }
    
    private String helper(int lower, int upper) {
        String str = Integer.toString(lower);
            
        if (upper > lower) {
            str += "->" + upper;
        }
        
        return str;
    }
}
