public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        int len = s.length();
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
        
        List<String> result = new ArrayList<>();
        
        if (dp[len]) {
            dfs(s, new HashSet<String>(wordDict), 0, "", result);
        }
        
        return result;
    }
    
    private void dfs(String s, Set<String> wordDict, int start, String curr, List<String> result) {
        if (start == s.length()) {
            result.add(curr);
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            
            if (wordDict.contains(word)) {
                dfs(s, wordDict, i, curr + (curr.length() > 0 ? " " : "") + word, result);
            }
        }
    }
}
