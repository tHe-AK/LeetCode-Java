class Solution {
    public String maskPII(String S) {
        int idx = S.indexOf('@');
        
        if (idx != -1) {
            S = S.toLowerCase();
            return S.substring(0, 1) + "*****" + S.substring(idx - 1);
        } else {
            S = S.replaceAll("\\D+", "");
            String str = "***-***-" + S.substring(S.length() - 4);
            
            if (S.length() == 10) {
                return str;
            }
            
            String prefix = "+";
            
            for (int i = 0; i < S.length() - 10; i++) {
                prefix += "*";
            }
            
            return prefix + "-" + str;
        }
    }
}
