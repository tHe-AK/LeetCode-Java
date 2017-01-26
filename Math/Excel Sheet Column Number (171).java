public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        return len == 0 ? 0 : 26 * titleToNumber(s.substring(0, len - 1)) + s.charAt(len - 1) - 'A' + 1;
    }
}

public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        
        return result;
    }
}
