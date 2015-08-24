class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        if (A == null || A.length < 3 || A[0].length < 3) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = A.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int j = 0;
            
            for (int i = 1; i < A[0].length; i++) {
                if (A[mid][i] > A[mid][j]) {
                    j = i;
                }
            }
            
            if (A[mid - 1][j] < A[mid][j] && A[mid][j] > A[mid + 1][j]) {
                result.add(mid);
                result.add(j);
                
                return result;
            }
            else if (A[mid - 1][j] > A[mid][j]) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        
        throw new IllegalArgumentException();
    }
}

