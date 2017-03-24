public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        
        long upper = (long) Math.pow(10, n) - 1;
        long lower = (long) Math.pow(10, n - 1);

        for (long i = upper; i >= lower; i--) {
            long num = getPalindrome(i);

            for (long j = upper; num / j <= j; j--) {
                if (num % j == 0 && num / j >= lower && num / j <= upper) {
                    return (int) (num % 1337);
                }
            }
        }
        
        return 0;
    }
    
    public long getPalindrome(long i) {
        return Long.parseLong(i + new StringBuilder(i + "").reverse().toString());
    }
}
