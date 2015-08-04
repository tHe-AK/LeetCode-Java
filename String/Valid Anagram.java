public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> rec = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (rec.containsKey(cur)) {
                rec.put(cur, rec.get(cur) + 1);
            }
            else {
                rec.put(cur, 1);
            }
        }
        
        for (int j = 0; j < t.length(); j++) {
            char cur = t.charAt(j);
            
            if (rec.containsKey(cur)) {
                if (rec.get(cur) > 1) {
                    rec.put(cur, rec.get(cur) - 1);
                }
                else {
                    rec.remove(cur);
                }
            }
            else {
                return false;
            }
        }
        
        return rec.keySet().size() == 0;
    }
}
