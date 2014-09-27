public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        int i = s.length() - 1;
        
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        while (i >= 0 && s.charAt(i) != ' ') {
            result++;
            i--;
        }
        
        return result;
    }
}