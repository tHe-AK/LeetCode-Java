public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int max = 0;
        
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return max;
        }
        
        int len1 = A.length();
        int len2 = B.length();
        int[][] rec = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0 && j > 0 && A.charAt(i - 1) == B.charAt(j - 1)) {
                    rec[i][j] = rec[i - 1][j - 1] + 1;
                    max = Math.max(max, rec[i][j]);
                }
            }
        }
        
        return max;
    }
}
