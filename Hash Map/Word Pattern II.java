public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        return dfs(pattern, str, 0, 0, map, set);
    }
    
    private boolean dfs(String pattern, String str, int i, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        
        char ch = pattern.charAt(i);
        
        if (map.containsKey(ch)) {
            String word = map.get(ch);
            
            if (str.startsWith(word, j)) {
                return dfs(pattern, str, i + 1, j + word.length(), map, set);
            } else {
                return false;
            }
        } else {
            for (int end = j + 1; end <= str.length(); end++) {
                String word = str.substring(j, end);
    
                if (set.contains(word)) {
                    continue;
                }
                
                map.put(ch, word);
                set.add(word);
                
                if (dfs(pattern, str, i + 1, end, map, set)) {
                    return true;
                }
                
                map.remove(ch);
                set.remove(word);
            }
            
            return false;
        }
    }
}
