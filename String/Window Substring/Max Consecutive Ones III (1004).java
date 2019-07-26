class Solution {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;
        
        while (end < A.length) {
            if (A[end++] == 0) {
                count++;
            }
            
            while (count > K) {
                if (A[start++] == 0) {
                    count--;
                }
            }
            
            max = Math.max(max, end - start);
        }
        
        return max;
    }
}
