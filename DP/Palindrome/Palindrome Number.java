public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        long high = 1;
        long low = 1;

        while (x / high > 0) {
            high *= 10;
        }
        
        high /= 10;

        while (low < high) {
            if (x / high % 10 != x / low % 10) {
                return false;
            }
            
            high /= 10;
            low *= 10;
        }
        
        return true;
    }
}
