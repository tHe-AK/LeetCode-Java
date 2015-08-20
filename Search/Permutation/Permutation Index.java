public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        long result = 0;
        long factorial = 1;
        
        for (int i = len - 2; i >= 0; i--) {
            int count = 0;
            
            for (int j = i + 1; j < len; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            
            result += count * factorial;
            factorial *= len - i;
        }
        
        return result + 1;
    }
}
