class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] rec = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    rec[i][j] = rec[i][j - 1] + s2.charAt(j - 1);
                } else if (j == 0) {
                    rec[i][j] = rec[i - 1][j] + s1.charAt(i - 1);
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    rec[i][j] = rec[i - 1][j - 1];
                } else {
                    rec[i][j] = Math.min(rec[i - 1][j] + s1.charAt(i - 1), rec[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        
        return rec[len1][len2];
    }
}
