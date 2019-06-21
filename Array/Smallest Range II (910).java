class Solution {
    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N - 1] - A[0];
        
        for (int i = 0; i < N - 1; i++) {
            int max = Math.max(A[i] + 2 * K, A[N - 1]);
            int min = Math.min(A[0] + 2 * K, A[i + 1]);
            ans = Math.min(ans, max - min);
        }
        
        return ans;
    }
}

class Solution {
    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N - 1] - A[0];
        
        for (int i = 0; i < N - 1; i++) {
            int max = Math.max(A[i] + K, A[N - 1] - K);
            int min = Math.min(A[0] + K, A[i + 1] - K);
            ans = Math.min(ans, max - min);
        }
        
        return ans;
    }
}
