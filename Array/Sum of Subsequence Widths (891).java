class Solution {
    public int sumSubseqWidths(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        long res = 0;
        long curr = 1;
        long MOD = 1_000_000_007;
        
        for (int i = 0; i < N; i++) {
            res = (res + A[i] * curr - A[N - i - 1] * curr) % MOD;
            curr = (curr << 1) % MOD;
        }
        
        return (int) res;
    }
}
