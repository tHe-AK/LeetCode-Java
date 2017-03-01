public class Solution {
    public int strongPasswordChecker(String s) {
        int len = s.length();
        int lower = 1;
        int upper = 1;
        int digit = 1;
        int[] rec = new int[len];

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (Character.isLowerCase(ch)) {
                lower = 0;
            } else if (Character.isUpperCase(ch)) {
                upper = 0;
            } else if (Character.isDigit(ch)) {
                digit = 0;
            }
            
            if (i > 0 && ch == s.charAt(i - 1)) {
                rec[i] = rec[i - 1] + 1;
                rec[i - 1] = 0;
            } else {
                rec[i] = 1;
            }
        }
        
        int insert = lower + upper + digit;
        
        if (len < 6) {
            int diff = 6 - len;
            return Math.max(insert, diff);
        } else {
            int delete = len > 20 ? len - 20 : 0;
            int count = delete;
            int replace = 0;
            
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < len && count > 0; i++) {
                    if (rec[i] >= 3 && rec[i] % 3 == k - 1) {
                        int diff = Math.min(k, count);
                        rec[i] -= diff;
                        count -= diff;
                    }
                }
            }
            
            for (int i = 0; i < len; i++) {
                if (rec[i] >= 3 && count > 0) {
                    int diff = Math.min(rec[i] - 2, count);
                    rec[i] -= diff;
                    count -= diff;
                }
                
                if (rec[i] >= 3) {
                    replace += rec[i] / 3;
                }
            }
            
            return delete + Math.max(insert, replace);
        }
    }
}
