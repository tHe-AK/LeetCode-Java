public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = p.charAt(j - 1);
                
                if (ch == s.charAt(i - 1) || ch == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }
    
    private boolean dfs(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (dfs(s, i, p, j + 2)) {
                return true;
            }
            
            while (i < s.length() && isEqual(s, i, p, j)) {
                if (dfs(s, i + 1, p, j + 2)) {
                    return true;
                }
                
                i++;
            }
            
            return false;
        } else {
            return i < s.length() && isEqual(s, i, p, j) && dfs(s, i + 1, p, j + 1);
        }
    }
    
    private boolean isEqual(String s, int i, String p, int j) {
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }
}
