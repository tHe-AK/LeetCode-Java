public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] rec = new boolean[m + 1][n + 1];
        rec[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                rec[0][j] = rec[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(j - 1);
                
                if (c == s.charAt(i - 1) || c == '.') {
                    rec[i][j] = rec[i - 1][j - 1];
                } else if (c == '*') {
                    if (p.charAt(j - 2) != '.' && s.charAt(i - 1) != p.charAt(j - 2)) {
                        rec[i][j] = rec[i][j - 2];
                    } else {
                        rec[i][j] = rec[i][j - 2] || rec[i][j - 1] || rec[i - 1][j];
                    }
                }
            }
        }
        
        return rec[m][n];
    }
}
