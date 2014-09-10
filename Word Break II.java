public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return result;
        }
        
        helper(s, dict, s.length() - 1, "", result);
        
        return result;
    }
    
    private void helper(String s, Set<String> dict, int end, String cur, List<String> result) {
        if (end == -1) {
            result.add(cur.trim());
            return;
        }
        
        for (int i = 0; i <= end; i++) {
            String word = s.substring(i, end + 1);
            if (dict.contains(word)) {
                helper(s, dict, i - 1, word + " " + cur, result);
            }
        }
    }
}
