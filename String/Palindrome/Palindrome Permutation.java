public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        HashSet<Character> rec = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (rec.contains(c)) {
                rec.remove(c);
            }
            else {
                rec.add(c);
            }
        }
        
        return rec.size() <= 1;
    }
}
