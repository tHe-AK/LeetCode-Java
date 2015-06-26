public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int pre = 0;
        int len = nums.length;
        
        for (int i = 1; i <= len; i++) {
            if (i == len || nums[i - 1] + 1 != nums[i] {
                String cur = String.valueOf(nums[pre]);
                
                if (pre < i - 1) {
                    cur += "->" + nums[i - 1];
                }
                
                result.add(cur);
                pre = i;
            }
        }
        
        return result;
    }
}
