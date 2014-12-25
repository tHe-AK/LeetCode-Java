public class Solution {
    public String convertToTitle(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        String result = "";
        
        while (n > 0) {
            int remaining = n % 26;
            
            if (remaining == 0) {
                result = 'Z' + result;
                n = n / 26 - 1;
            }
            else {
                result = (char)('A' + remaining - 1) + result;
                n /= 26;
            }
        }
        
        return result;
    }
}