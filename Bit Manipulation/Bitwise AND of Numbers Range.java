public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m > n) {
            throw new IllegalArgumentException();
        }
        
        while (m < n) {
            n &= n - 1;
        }
        
        return m & n;
    }
}
