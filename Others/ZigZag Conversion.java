public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0) {
            return "";
        }
        
        if (nRows == 1) {
            return s;
        }
        
        String result = "";
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += 2 * (nRows - 1)) {
                result += s.charAt(j);
                if (i != 0 && i != nRows - 1 && j + 2 * (nRows - 1 - i) < s.length()) {
                    result += s.charAt(j + 2 * (nRows - 1 - i));
                }
            }
        }
        
        return result;
    }
}
