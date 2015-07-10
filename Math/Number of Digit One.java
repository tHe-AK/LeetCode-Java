public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        
        if (n < 0) {
            return count;
        }
        
        long val = 1;
        
        while (n / val > 0) {
            long high = n / (val * 10);
            long cur = (n / val) % 10;
            long low = n % val;
            
            if (cur == 1) {
                count += high * val + low + 1;
            }
            else if (cur < 1) {
                count += high * val;
            }
            else {
                count += (high + 1) * val;
            }
            
            val *= 10;
        }
        
        return count;
    }
}
