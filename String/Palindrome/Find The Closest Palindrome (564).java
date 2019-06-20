class Solution {
    public String nearestPalindromic(String n) {
        List<String> list = new ArrayList<>();
        long min = Long.MAX_VALUE;
        String res = "";
        
        list.add(mirroring(n, -1));
        list.add(mirroring(n, 0));
        list.add(mirroring(n, 1));
        
        for (String str : list) {
            long diff = Math.abs(Long.parseLong(str) - Long.parseLong(n));
            
            if (diff > 0 && diff < min) {
                min = diff;
                res = str;
            }
        }
        
        return res;
    }
    
    private String mirroring(String s, int diff) {
        int len = s.length();
        int idx = (len + 1) / 2;
        int x = Integer.valueOf(s.substring(0, idx));
        int y = x + diff;
        
        if (y == 0 || String.valueOf(y).length() < String.valueOf(x).length()) {
            String str = "";
            
            for (int i = 0; i < len - 1; i++) {
                str += "9";
            }
            
            return str.isEmpty() ? "0" : str;
        }
        
        String str = String.valueOf(y);
        return str + new StringBuilder(str.substring(0, len - idx)).reverse().toString();
    }
}
