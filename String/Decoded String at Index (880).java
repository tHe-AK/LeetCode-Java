class Solution {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                len *= ch - '0';
            } else {
                len++;
            }
        }
        
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            K %= len;
            
            if (Character.isDigit(ch)) {
                len /= ch - '0';
            } else {
                if (K == 0) {
                    return String.valueOf(ch);
                }
                
                len--;
            }
        }
        
        return null;
    }
}
