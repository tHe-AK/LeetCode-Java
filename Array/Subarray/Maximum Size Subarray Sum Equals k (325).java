public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int val = sum - k;
            
            if (map.containsKey(val)) {
                max = Math.max(max, i - map.get(val));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
