public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int len = String.valueOf(x).length();
        int low = 1;
        int high = (int) Math.pow(10, len - 1);
        
        while (low < high) {
            if (x / low % 10 != x / high % 10) {
                return false;
            }
            low *= 10;
            high /= 10;
        }
        
        return true;
    }
}
