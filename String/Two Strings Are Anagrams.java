public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] rec = new int[256];

        for (int i = 0; i < s.length(); i++) {
            rec[s.charAt(i)]++;
        }
        
        for (int j = 0; j < t.length(); j++) {
            int index = t.charAt(j);
            
            if (rec[index] == 0) {
                return false;
            }
            else {
                rec[index]--;
            }
        }
        
        for (int k = 0; k < rec.length; k++) {
            if (rec[k] > 0) {
                return false;
            }
        }
        
        return true;
    }
};
