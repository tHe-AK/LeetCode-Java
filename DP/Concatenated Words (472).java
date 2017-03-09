public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordDict = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for (String word : words) {
            if (wordBreak(word, wordDict)) {
                result.add(word);
            }
            
            wordDict.add(word);
        }
        
        return result;
    }
    
    private boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        
        if (len == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}
