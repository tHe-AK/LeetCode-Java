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
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        rec[i][j] = rec[i][j - 2] || rec[i - 1][j];
                    } else {
                        rec[i][j] = rec[i][j - 2];
                    }
                }
            }
        }
        
        return rec[m][n];
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }
    
    private boolean dfs(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (dfs(s, i, p, j + 2)) {
                return true;
            }
            
            while (i < s.length() && equal(s, i, p, j)) {
                if (dfs(s, i + 1, p, j + 2)) {
                    return true;
                }
                
                i++;
            }
            
            return false;
        }
        else {
            return i < s.length() && equal(s, i, p, j) && dfs(s, i + 1, p, j + 1);
        }
    }
    
    private boolean equal(String s, int i, String p, int j) {
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }
}
