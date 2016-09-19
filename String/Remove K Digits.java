public class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() < k) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < num.length()) {
            char c = num.charAt(i);
            
            if (sb.length() > 0 && k > 0) {
                int last = sb.length() - 1;
                
                if (sb.charAt(last) > c) {
                    sb.deleteCharAt(last);
                    k--;
                    continue;
                }
            }
            
            sb.append(c);
            i++;
        }
        
        if (k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }
        
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
