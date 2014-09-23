public class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] rec = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0;j < len2 + 1; j++) {
                if (i == 0 || j == 0) {
                    rec[i][j] = 0;
                }
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    rec[i][j] = rec[i - 1][j - 1] + 1;
                }
                else {
                    rec[i][j] = Math.max(rec[i - 1][j], rec[i][j - 1]);
                }
            }
        }
        
        return rec[len1][len2];
    }
}
