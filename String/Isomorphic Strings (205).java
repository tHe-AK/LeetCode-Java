public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int[] rec1 = new int[256];
        int[] rec2 = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            int ch1 = s.charAt(i);
            int ch2 = t.charAt(i);
            
            if (rec1[ch1] == rec2[ch2]) {
                rec1[ch1] = rec2[ch2] = i + 1;
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
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if (map.containsKey(ch1)) {
                if (map.get(ch1) == ch2) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (set.contains(ch2)) {
                    return false;
                }

                map.put(ch1, ch2);
                set.add(ch2);
            }
        }
        
        return true;
    }
}
