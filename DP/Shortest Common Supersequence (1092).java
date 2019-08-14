class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int M = str1.length();
        int N = str2.length();
        String[][] dp = new String[M + 1][N + 1];
        String str = "";
        
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        
        int i = 0;
        int j = 0;
        
        for (char ch : dp[M][N].toCharArray()) {
            while (str1.charAt(i) != ch) {
                str += str1.charAt(i++);
            }
            
            while (str2.charAt(j) != ch) {
                str += str2.charAt(j++);
            }
            
            str += ch;
            i++;
            j++;
        }
        
        return str + str1.substring(i) + str2.substring(j);
    }
}
