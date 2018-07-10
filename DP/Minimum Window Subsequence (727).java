class Solution {
    public String minWindow(String S, String T) {
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        int min = Integer.MAX_VALUE;
        int start = -1;
        
        for (int i = 0; i <= m; i++) {
        	for (int j = 0; j <= n; j++) {
        		if (i == 0) {
        			dp[i][j] = j;
        		} else if (j == 0) {
        			dp[i][j] = -1;
        		} else {
        			if (T.charAt(i - 1) == S.charAt(j - 1)) {
        				dp[i][j] = dp[i - 1][j - 1];
        				if (i == m && dp[i][j] != -1 && j - dp[i][j] < min) {
        					min = j - dp[i][j];
        					start = dp[i][j];
        				}
        			} else {
        				dp[i][j] = dp[i][j - 1];
        			}
        		}
        	}
        }
        
        for (int[] x : dp) {
        	for (int y : x) {
        		System.out.print(y + " ");
        	}
        	System.out.println();
        }
        
        return start != -1 ? S.substring(start, start + min) : "";
    }
}
