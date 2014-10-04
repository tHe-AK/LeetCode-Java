public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int len = s1.length();
        boolean[][][] rec = new boolean[len][len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rec[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        for (int k = 1; k < len; k++) {
            for (int i = 0; i < len - k; i++) {
                for (int j = 0; j < len - k; j++) {
                    for (int l = 0; l < k; l++) {
                        if ((rec[i][j][l] && rec[i + l + 1][j + l + 1][k - l - 1]) || (rec[i][j + k - l][l] && rec[i + l + 1][j][k - l - 1])) {
                            rec[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return rec[0][0][len - 1];
    }
}