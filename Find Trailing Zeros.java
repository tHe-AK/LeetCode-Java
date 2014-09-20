public class Solution {
    public int findTrailingZeros(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        
        for (int i = 5; i <= x; i *= 5) {
            result += x / i;
        }
        
        return result;
    }
}
