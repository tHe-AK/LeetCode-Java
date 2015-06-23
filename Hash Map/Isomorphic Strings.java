public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashMap<Character, Character> mapReverse = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            
            if (map.containsKey(x) && map.get(x) != y) {
                return false;
            }
            
            if (mapReverse.containsKey(y) && mapReverse.get(y) != x) {
                return false;
            }
            
            map.put(x, y);
            mapReverse.put(y, x);
        }
        
        return true;
    }
}
