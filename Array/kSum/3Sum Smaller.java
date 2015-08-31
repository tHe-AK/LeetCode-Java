public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                
                if (sum < target) {
                    count += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        
        return count;
    }
}
