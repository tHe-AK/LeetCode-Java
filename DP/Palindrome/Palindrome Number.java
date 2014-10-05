public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int cur = x;
        int high = 1;
        int low = 1;

        while (cur / 10 != 0) {
            high *= 10;
            cur /= 10;
        }

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