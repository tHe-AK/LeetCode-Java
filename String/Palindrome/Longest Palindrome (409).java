public class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (set.remove(ch)) {
                count++;
            } else {
                set.add(ch);
            }
        }
        
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
