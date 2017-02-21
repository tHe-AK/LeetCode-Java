public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        
        int count = 10;
        int base = 9;
            
        for (int i = 2; i <= n && i <= 10; i++) {
            base *= 9 - i + 2;
            count += base;
        }
        
        return count;
    }
}
