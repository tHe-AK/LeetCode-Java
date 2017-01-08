public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] rec = new boolean[m + 1][n + 1];
        rec[0][0] = true;
        
        for (int j = 1; j <= n && p.charAt(j - 1) == '*'; j++){
            rec[0][j] = true;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    rec[i][j] = rec[i][j - 1] || rec[i - 1][j];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    rec[i][j] = rec[i - 1][j - 1];
                }
            }
        }
        
        return rec[m][n];
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int index = -1;
        int star = -1;
        
        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                index = i;
                star = j;
                j++;
            }
            else if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (star != -1) {
                i = ++index;
                j = star + 1;
            }
            else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}
