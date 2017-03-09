public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        
        for (int j = 0; j < 32; j++) {
            int count = 0;
            
            for (int num : nums) {
                count += (num >> j) & 1;
            }
            
            total += count * (n - count);
        }
        
        return total;
    }
}
