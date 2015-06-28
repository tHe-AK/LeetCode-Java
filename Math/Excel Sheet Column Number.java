public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count *= 26;
            count += s.charAt(i) - 'A' + 1;
        }
        
        return count;
    }
}
