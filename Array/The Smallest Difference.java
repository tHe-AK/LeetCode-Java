public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            throw new IllegalArgumentException();
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        int j = 0;
        int diff = Integer.MAX_VALUE;
        
        while (i < A.length && j < B.length) {
            diff = Math.min(diff, Math.abs(A[i] - B[j]));
            
            if (A[i] < B[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return diff;
    }
}

