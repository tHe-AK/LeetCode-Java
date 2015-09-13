class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int len = A.length;
        int pre = 0;
        int cur = 0;
        
        for (int i = 0; i < len; i++) {
            if (A[i] < 0) {
                int temp = A[cur];
                A[cur] = A[i];
                A[i] = temp;
                cur++;
            }
        }
        
        if (cur > len - cur) {
            pre = 1;
        }
        
        while (pre < cur && cur < len && A[pre] < 0) {
            int temp = A[pre];
            A[pre] = A[cur];
            A[cur] = temp;
            pre += 2;
            cur++;
        }
   }
}
