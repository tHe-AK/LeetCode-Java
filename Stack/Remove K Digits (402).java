public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        k = len - k;
        char[] str = new char[k];
        int idx = 0;
        
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            
            while (idx > 0 && idx + len - i > k && str[idx - 1] > ch) {
                idx--;
            }
            
            if (idx < k) {
                str[idx++] = ch;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < k; i++) {
            if (str[i] != '0' || sb.length() > 0) {
                sb.append(str[i]);
            }
        }
        
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
