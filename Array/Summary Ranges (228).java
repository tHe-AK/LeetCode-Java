public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        int start = 0;
        
        for (int i = 1; i <= len; i++) {
            if (i == len || nums[i - 1] + 1 < nums[i]) {
                if (start == i - 1) {
                    res.add(nums[start] + "");
                } else {
                    res.add(nums[start] + "->" + nums[i - 1]);
                }
                
                start = i;
            }
        }
        
        return res;
    }
}

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
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
