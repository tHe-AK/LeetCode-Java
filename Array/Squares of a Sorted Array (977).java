class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        int low = 0;
        int high = N - 1;
        
        for (int i = N - 1; i >= 0; i--) {
            if (Math.abs(A[low]) > Math.abs(A[high])) {
                res[i] = A[low] * A[low++];
            } else {
                res[i] = A[high] * A[high--];
            }
        }
        
        return res;
    }
}
