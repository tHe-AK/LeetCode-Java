public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException();
        }
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean[][] rec = new boolean[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 && j == 0) {
                    rec[i][j] = true;
                }
                
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && rec[i - 1][j]) {
                    rec[i][j] = true;
                }
                
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && rec[i][j - 1]) {
                    rec[i][j] = true;
                }
            }
        }
        
        return rec[len1][len2];
    }
}