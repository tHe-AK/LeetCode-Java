public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            throw new IllegalArgumentException();
        }
        
        int len1 = pattern.length();
        String[] words = str.split(" ");
        int len2 = words.length;
        
        if (len1 != len2) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        for (int i = 0; i < len1; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (map.containsKey(c)) {
                if (map.get(c).equals(word)) {
                    continue;
                } else {
                    return false;
                }
            }
            
            if (set.contains(word)) {
                return false;
            }
            
            map.put(c, word);
            set.add(word);
        }
        
        return true;
    }
}
