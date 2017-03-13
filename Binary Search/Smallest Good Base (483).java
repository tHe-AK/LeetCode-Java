public class Solution {
    public String smallestGoodBase(String n) {
        long num = 0;
        
        for (char ch : n.toCharArray()) {
            num = num * 10 + ch - '0';
        }
        
        for (int i = 63; i > 1; i--) {
            if (((1L << i) - 1) <= num) {
                long base = binarySearch(num, i);
                
                if (base != -1) {
                    return String.valueOf(base);
                }
            }
        }
        
        return String.valueOf(num - 1);
    }
    
    private long binarySearch(long num, int i) {
        long low = 2;
        long high = (long) Math.pow(num, 1.0 / (i - 1));
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = 0;
            
            for (int j = 0; j < i; j++) {
                sum = sum * mid + 1;
            }
            
            if (sum == num) {
                return mid;
            } else if (sum > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}
