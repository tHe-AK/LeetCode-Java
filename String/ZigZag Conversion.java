public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows < 1) {
            throw new IllegalArgumentException();
        }
        
        if (nRows == 1) {
            return s;
        }
        
        String result = "";
        int count = 2 * nRows - 2;
        
        for (int i = 0; i < s.length() && i < nRows; i++) {
            for (int j = i; j < s.length(); j += count) {
                result += s.charAt(j);
                    
                if (i > 0 && i < nRows - 1 && j + count - 2 * i < s.length()) {
                    result += s.charAt(j + count - 2 * i);
                }
            }
        }
        
        return result;
    }
}