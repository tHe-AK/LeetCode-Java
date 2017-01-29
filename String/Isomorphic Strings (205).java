public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] rec1 = new int[256];
        int[] rec2 = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            int char1 = s.charAt(i);
            int char2 = t.charAt(i);
            
            if (rec1[char1] == rec2[char2]) {
                rec1[char1] = rec2[char2] = i + 1;
            } else {
                return false;
            }
        }
        
        return true;
    }
}

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            
            if (map.containsKey(char1)) {
                if (map.get(char1) == char2) {
                    continue;
                } else {
                    return false;
                }
            }
            
            if (set.contains(char2)) {
                return false;
            }
            
            map.put(char1, char2);
            set.add(char2);
        }
        
        return true;
    }
}
