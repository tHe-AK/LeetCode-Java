public class Solution {
    public int findKthNumber(int n, int k) {
        if (k < 1 || n < k || n > Math.pow(10, 9)) {
            throw new IllegalArgumentException();
        }
        
        long cur = 1;
        
        while (k > 1) {
            long start = cur;
            long end = cur + 1;
            long count = 0;
            
            while (start <= n) {
                count += Math.min(end, n + 1) - start;
                start *= 10;
                end *= 10;
            }
            
            if (k > count) {
                k -= count;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        
        return (int) cur;
    }
}
