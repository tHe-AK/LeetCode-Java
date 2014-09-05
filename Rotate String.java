public class Solution {
    public String RotateString(String str, int offset) {
        if (offset < 0) {
            return null;
        }
        
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        offset = offset % str.length();
        if (offset == 0) {
            return str;
        }
        
        StringBuilder sb = new StringBuilder(str);
        helper(sb, 0, sb.length() - offset - 1);
        helper(sb, sb.length() - offset, sb.length() - 1);
        helper(sb, 0, sb.length() - 1);
        
        return sb.toString();
    }

    private void helper(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
