class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        int[] left = new int[n];
        left[k - 1] = 0;
        int max = sum[k];
        
        for (int i = k; i < n; i++) {
            int curr = sum[i + 1] - sum[i - k + 1];
                
            if (curr > max) {
                max = curr;
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }
        
        int[] right = new int[n];
        right[n - k] = n - k;
        max = sum[n] - sum[n - k];
        
        for (int i = n - k - 1; i >= 0; i--) {            
            int curr = sum[i + k] - sum[i];
                
            if (curr >= max) {
                max = curr;
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        
        max = 0;
        int[] res = new int[3];
        
        for (int i = k; i <= n - 2 * k; i++) {
            int total = sum[i + k] - sum[i];
            int x = left[i - 1];
            int y = right[i + k];
            total += sum[x + k] - sum[x] + sum[y + k] - sum[y];
            
            if (total > max) {
                max = total;
                res[0] = x;
                res[1] = i;
                res[2] = y;
            }
        }
        
        return res;
    }
}
