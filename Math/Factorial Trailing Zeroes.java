public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        int count = 0;
        
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        
        return count;
    }
}
