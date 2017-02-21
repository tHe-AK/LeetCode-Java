public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            int[] nums = new int[n];
            
            for (int l = i; l < m; l++) {
                for (int j = 0; j < n; j++) {
                    nums[j] += matrix[l][j];
                }
                
                max = Math.max(max, maxSubArray(nums, k));
            }
        }
        
        return max;
    }
    
    private int maxSubArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        for (int num : nums) {
            sum += num;
            Integer ceiling = set.ceiling(sum - k);
            
            if (ceiling != null) {
                max = Math.max(max, sum - ceiling);
            }
            
            set.add(sum);
        }
        
        return max;
    }
}
