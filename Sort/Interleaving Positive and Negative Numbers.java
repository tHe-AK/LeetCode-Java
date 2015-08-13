class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int neg = 0;
        int pos = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                neg++;
            }
            else {
                pos++;
            }
        }
        
        int negId = 0;
        int posId = 1;
        
        if (neg < pos) {
            negId = 1;
            posId = 0;
        }
        
        while (negId < A.length && posId < A.length) {
            while (negId < A.length && A[negId] < 0) {
                negId += 2;
            }
            
            while (posId < A.length && A[posId] >= 0) {
                posId += 2;
            }
            
            if (negId < A.length && posId < A.length) {
                int temp = A[negId];
                A[negId] = A[posId];
                A[posId] = temp;
                negId += 2;
                posId += 2;
            }
        }
   }
}
