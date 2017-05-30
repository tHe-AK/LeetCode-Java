public class Solution {
    public int arrayNesting(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int count = 0;
                int j = nums[i];
                
                while (j != i) {
                    visited[j] = true;
                    count++;
                    j = nums[j];
                }
                
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}
