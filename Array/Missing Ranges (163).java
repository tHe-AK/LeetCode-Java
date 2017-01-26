public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int n = nums.length;
        
        for (int i = 0; i <= n; i++) {
            long left = i == 0  ? lower : (long) nums[i - 1] + 1;
            long right = i == n ? upper : (long) nums[i] - 1;
            
            if (left <= right) {
                result.add(getRange(left, right));
            }
        }

        return result;
    }
    
    private String getRange(long lower, long upper) {
        return lower == upper ? lower + "" : lower + "->" + upper;
    }
}
