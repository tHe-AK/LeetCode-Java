public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        
        helper(s, dict, s.length() - 1, "", result);
        
        return result;
    }
    
    private void helper(String s, Set<String> dict, int start, String cur, List<String> result) {
        if (start == -1) {
            result.add(cur.trim());
            return;
        }
        
        for (int i = 0; i <= start; i++) {
            String word = s.substring(i, start + 1);
            
            if (dict.contains(word)) {
                helper(s, dict, i - 1, word + " " + cur, result);
            }
        }
    }
}