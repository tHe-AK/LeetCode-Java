public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] rec = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    rec[i][j] = j;
                } else if (j == 0) {
                    rec[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    rec[i][j] = rec[i - 1][j - 1];
                } else {
                    rec[i][j] = Math.min(Math.min(rec[i][j - 1], rec[i - 1][j]), rec[i - 1][j - 1]) + 1;
                }
            }
        }
        
        return rec[len1][len2];
    }
}
