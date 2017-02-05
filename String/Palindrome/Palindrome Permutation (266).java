public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> rec = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (rec.contains(ch)) {
                rec.remove(ch);
            } else {
                rec.add(ch);
            }
        }
        
        return rec.size() <= 1;
    }
}
