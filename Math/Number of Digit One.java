public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long val = 1;
        
        while (n / val > 0) {
            long high = n / (val * 10);
            long curr = (n / val) % 10;
            long low = n % val;
            count += high * val;
            
            if (curr == 1) {
                count += low + 1;
            } else if (curr > 1) {
                count += val;
            }
            
            val *= 10;
        }
        
        return count;
    }
}
