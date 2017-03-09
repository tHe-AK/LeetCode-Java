public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        
        if (len == 0) {
            return false;
        }
        
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}
