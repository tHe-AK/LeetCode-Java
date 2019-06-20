class Solution {
    public String nearestPalindromic(String n) {
        List<Long> list = new ArrayList<>();
        long num =  Long.parseLong(n);
        long min = Long.MAX_VALUE;
        long res = 0;
        
        list.add(mirroring(n, -1));
        list.add(mirroring(n, 0));
        list.add(mirroring(n, 1));
        
        for (Long candidate : list) {
            long diff = Math.abs(candidate - num);
            
            if (diff > 0 && diff < min) {
                min = diff;
                res = candidate;
            }
        }
        
        return String.valueOf(res);
    }
    
    private long mirroring(String s, int diff) {
        int len = s.length();
        int idx = (len + 1) / 2;
        int x = Integer.valueOf(s.substring(0, idx));
        int y = x + diff;
        
        if (y == 0 || String.valueOf(y).length() < String.valueOf(x).length()) {
            long num = 0;
            
            for (int i = 0; i < len - 1; i++) {
                num = num * 10 + 9;
            }
            
            return num;
        }
        
        String left = String.valueOf(y);
        String right = new StringBuilder(left.substring(0, len - idx)).reverse().toString();
        return Long.parseLong(left + right);
    }
}
