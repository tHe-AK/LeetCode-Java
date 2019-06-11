class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int gcd = gcd(A, B);
        int lcm = A / gcd * B;
        int divisor = lcm / A + lcm / B - 1;
        int quotient = N / divisor;
        int remainder = N % divisor;
        long ans = (long) lcm * quotient % MOD;
        
        if (remainder == 0) {
            return (int) ans;
        }
        
        int candidate1 = A;
        int candidate2 = B;
        
        for (int i = 0; i < remainder - 1; i++) {
            if (candidate1 < candidate2) {
                candidate1 += A;
            } else {
                candidate2 += B;
            }
        }
        ans = (ans + Math.min(candidate1, candidate2) % MOD) % MOD;
        return (int) ans;
    }
    
    private int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        
        return gcd(B, A % B);
    }
}
