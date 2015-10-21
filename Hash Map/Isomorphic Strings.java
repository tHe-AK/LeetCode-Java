public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            
            if (map.containsKey(x)) {
                if (map.get(x) == y) {
                    continue;
                } else {
                    return false;
                }
            }
            
            if (set.contains(y)) {
                return false;
            }
            
            map.put(x, y);
            set.add(y);
        }
        
        return true;
    }
}
