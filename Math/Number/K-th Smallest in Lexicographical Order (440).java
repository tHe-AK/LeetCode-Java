public class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        
        while (k > 1) {
            long start = curr;
            long end = curr + 1;
            long count = 0;
            
            while (start <= n) {
                count += Math.min(end, n + 1) - start;
                start *= 10;
                end *= 10;
            }
            
            if (k > count) {
                k -= count;
                curr++;
            } else {
                k--;
                curr *= 10;
            }
        }
        
        return (int) curr;
    }
}
