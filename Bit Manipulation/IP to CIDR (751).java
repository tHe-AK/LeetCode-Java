class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long num = strToNum(ip);
        List<String> list = new ArrayList<>();
        
        while (n > 0) {
            int count = Math.min(getLen(Long.lowestOneBit(num)), getLen(n)) - 1;
            list.add(numToStr(num, 32 - count));
            num += 1 << count;
            n -= 1 << count;
        }
        
        return list;
    }
    
    private long strToNum(String str) {
        String[] strs = str.split("\\.");
        long num = 0;
        
        for (String s : strs) {
            num = num * 256 + Integer.parseInt(s);
        }
        
        return num;
    }
    
    private String numToStr(long num, int n) {
        String str = "";
        
        while (num > 0) {
            str = (num % 256) + (str.isEmpty() ? "" : ".") + str;
            num /= 256;
        }
        
        return str + "/" + n;
    }
    
    private int getLen(long num) {
        if (num == 0) {
            return 0;
        }
        
        int len = 0;
        
        while (num > 0) {
            num >>= 1;
            len++;
        }
        
        return len;
    }
}
