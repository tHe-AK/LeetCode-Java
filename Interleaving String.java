public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] rec = new boolean[len1 + 1][len2 + 1];
        rec[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (rec[i - 1][0] == true && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                rec[i][0] = true;
            }
        }
        for (int j = 1; j <= len2; j++) {
            if (rec[0][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                rec[0][j] = true;
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && rec[i - 1][j] == true) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && rec[i][j - 1] == true)) {
                    rec[i][j] = true;
                }
            }
        }
        
        return rec[len1][len2];
    }
}
