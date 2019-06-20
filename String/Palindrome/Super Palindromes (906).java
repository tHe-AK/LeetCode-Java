class Solution {
    public int superpalindromesInRange(String L, String R) {
        int count = 0;
        long low = (long) Math.sqrt(Long.parseLong(L));
        low = nextPalindrome(low);
        long high = (long) Math.sqrt(Long.parseLong(R));
        
        while (low <= high) {
            if (isPalindrome(low * low)) {
                count++;
            }
            
            low = nextPalindrome(low + 1);
        }
        
        return count;
    }
    
    private long nextPalindrome(long num) {
        List<Long> list = new ArrayList<>();
        long min = Long.MAX_VALUE;
        long res = 0;
        
        list.add(mirroring(num, 0));
        list.add(mirroring(num, 1));
        
        for (Long candidate : list) {
            long diff = candidate - num;
            
            if (diff >= 0 && diff < min) {
                min = diff;
                res = candidate;
            }
        }
        
        return res;
    }
    
    private long mirroring(long num, int diff) {
        String str = String.valueOf(num);
        int len = str.length();
        int idx = (len + 1) / 2;
        int x = Integer.valueOf(str.substring(0, idx));
        int y = x + diff;
        String left = String.valueOf(y);
        String right = new StringBuilder(left.substring(0, len - idx)).reverse().toString();
        return Long.parseLong(left + right);
    }
    
    private boolean isPalindrome(long num) {
        long half = 0;
        
        while (half < num) {
            half = half * 10 + num % 10;
            num /= 10;
        }
        
        return half == num || half / 10 == num;
    }
}
