public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            int j = i;
            
            while (i + 1 < len && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            
            if (i == j) {
                result.add(nums[j] + "");
            } else {
                result.add(nums[j] + "->" + nums[i]);
            }
        }
        
        return result;
    }
}
