public class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] rec = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (j == 0) {
                    rec[i][j] = 1;
                } else if (i == 0) {
                    rec[i][j] = 0;
                } else {
                    rec[i][j] = rec[i - 1][j];
                    
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        rec[i][j] += rec[i - 1][j - 1];
                    }
                }
            }
        }
        
        return rec[len1][len2];
    }
}
