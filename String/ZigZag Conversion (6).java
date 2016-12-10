public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        int len = s.length();
        int j = 0;
        
        while (j < len) {
            for (int i = 0; i < numRows && j < len; i++) {
                sb[i].append(s.charAt(j++));
            }
            
            for (int i = numRows - 2; i > 0 && j < len; i--) {
                sb[i].append(s.charAt(j++));
            }
        }
        
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        
        return sb[0].toString();
    }
}
