class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int num = -1;
        int max = 0;
        int diff = 0;
        
        for (int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            int val = count.getOrDefault(nums[i], 0) + 1;
            count.put(nums[i], val);
            
            if (val > max || (val == max && right.get(nums[i]) - left.get(nums[i]) + 1 < diff)) {
                num = nums[i];
                max = val;
                diff = right.get(nums[i]) - left.get(nums[i]) + 1;
            }
        }
        
        return diff;
    }
}
