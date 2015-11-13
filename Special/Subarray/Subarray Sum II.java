public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        int len = A.length;
        int[] rec = new int[len + 1];
        
        for (int i = 1; i <= len; i++) {
            rec[i] = rec[i - 1] + A[i - 1];
            
            for (int j = 0; j < i; j++) {
                int diff = rec[i] - rec[j];
                
                if (diff >= start && diff <= end) {
                    result++;
                }
            }
        }
        
        return result;
    }
}
