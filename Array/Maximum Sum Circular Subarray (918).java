class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int currMax = 0;
        int currMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            currMax = Math.max(currMax + A[i], A[i]);
            max = Math.max(max, currMax);
            currMin = Math.min(currMin + A[i], A[i]);
            min = Math.min(min, currMin);
            sum += A[i];
        }
        
        return max >= 0 ? Math.max(max, sum - min) : max;
    }
}
