public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long[] rec = new long[len + 1];
        int[] count = new int[1];
        
        for (int i = 1; i <= len; i++) {
            rec[i] = rec[i - 1] + nums[i - 1];
        }
        
        mergeSort(rec, 0, len, lower, upper, count);
        
        return count[0];
    }
    
    private long[] mergeSort(long[] nums, int start, int end, int lower, int upper, int[] count) {
        if (start > end) {
            return new long[0];
        } else if (start == end) {
            return new long[] { nums[start] };
        } else {
            int mid = start + (end - start) / 2;
            int m = mid - start + 1;
            int n = end - mid;
            
            long[] left = mergeSort(nums, start, mid, lower, upper, count);
            long[] right = mergeSort(nums, mid + 1, end, lower, upper, count);
            long[] sorted = new long[m + n];

            for (int i = 0, j = 0, k = 0; i < m; i++) {
                while (j < n && right[j] - left[i] < lower) {
                    j++;
                }
                
                while (k < n && right[k] - left[i] <= upper) {
                    k++;
                }
                
                count[0] += k - j;
            }
            
            for (int i = 0, j = 0, k = 0; k < m + n; k++) {
                if (i == m || (j < n && left[i] > right[j])) {
                    sorted[k] = right[j++];
                } else {
                    sorted[k] = left[i++];
                }
            }
            
            return sorted;
        }
    }
}
