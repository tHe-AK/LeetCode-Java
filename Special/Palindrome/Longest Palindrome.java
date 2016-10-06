public class Solution {
    public int longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int count = 0;
        Set<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
