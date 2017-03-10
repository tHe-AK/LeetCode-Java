public class Solution {
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];
    
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                String str = s.substring(i, j + 1);
                dp[i][j] = str;
                
                if (j - i >= 4) {
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    
                    for (int k = 0; k < str.length() / 2; k++) {
                        String repeat = str.substring(0, k + 1);
                        
                        if (str.length() % repeat.length() == 0 && str.replaceAll(repeat, "").length() == 0) {
                            String encoded = str.length() / repeat.length() + "[" + dp[i][i + k] + "]";
                            
                            if (encoded.length() < dp[i][j].length()) {
                                dp[i][j] = encoded;
                            }
                        }
                    }
                }
            }
        }
    
        return dp[0][len - 1];
    }
}
