public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int j = 1; j <= n && p.charAt(j - 1) == '*'; j++){
            dp[0][j] = true;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = p.charAt(j - 1);
                
                if (ch == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (s.charAt(i - 1) == ch || ch == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int idx = -1;
        int star = -1;
        
        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                idx = i;
                star = j++;
            } else if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (star != -1) {
                i = ++idx;
                j = star + 1;
            } else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }
    
    private boolean dfs(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        } else if (p.charAt(j) == '*') {
            if (dfs(s, i, p, j + 1)) {
                return true;
            }
            
            while (i < s.length()) {
                if (dfs(s, i + 1, p, j + 1)) {
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
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '?';
    }
}
