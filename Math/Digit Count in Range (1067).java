class Solution {
    public int digitsCount(int d, int low, int high) {
        return helper(d, high) - helper(d, low - 1);
    }
    
    private int helper(int d, int n) {
        int count = 0;
        long val = 1;
        
        while (n / val > 0) {
            long high = n / (val * 10);
            long curr = (n / val) % 10;
            long low = n % val;
            
            if (d != 0 || high > 0) {
                count += (d != 0 ? high : (high - 1)) * val;
            
                if (curr == d) {
                    count += low + 1;
                } else if (curr > d) {
                    count += val;
                }
            }
            
            val *= 10;
        }
        
        return count;
    }
}
