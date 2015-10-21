public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            throw new IllegalArgumentException();
        }
        
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        return helper(pattern, 0, str, 0, map, set);
    }
    
    private boolean helper(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        
        char c = pattern.charAt(i);
        
        if (map.containsKey(c)) {
            String word = map.get(c);
            
            if (str.startsWith(word, j)) {
                return helper(pattern, i + 1, str, j + word.length(), map, set);
            } else {
                return false;
            }
        }

        for (int x = j + 1; x <= str.length(); x++) {
            String word = str.substring(j, x);

            if (set.contains(word)) {
                continue;
            }
            
            map.put(c, word);
            set.add(word);
            
            if (helper(pattern, i + 1, str, x, map, set)) {
                return true;
            }
            
            map.remove(c);
            set.remove(word);
        }
        
        return false;
    }
}
