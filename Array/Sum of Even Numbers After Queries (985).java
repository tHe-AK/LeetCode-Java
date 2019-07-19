class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int N = queries.length;
        int[] res = new int[N];
        int sum = 0;
        
        for (int i : A) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        
        for (int i = 0; i < N; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            
            if (A[idx] % 2 == 0) {
                sum -= A[idx];
            }
            
            A[idx] += val;
            
            if (A[idx] % 2 == 0) {
                sum += A[idx];
            }
            
            res[i] = sum;
        }
        
        return res;
    }
}
