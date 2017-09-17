class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        k = len - k;
        char[] str = new char[k];
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            
            while (idx > 0 && str[idx - 1] > ch && idx + len - i > k) {
                idx--;
            }
            
            if (idx < k) {
                str[idx++] = ch;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < k - 1 && str[i] == '0') {
            i++;
        }
        
        while (i < k) {
            sb.append(str[i]);
            i++;
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
