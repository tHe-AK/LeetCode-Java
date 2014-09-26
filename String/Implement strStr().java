public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            throw new IllegalArgumentException();
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int k;
            
            for (k = 0; k < needle.length(); k++) {
                if (haystack.charAt(i + k) != needle.charAt(k)) {
                    break;
                }
            }
            
            if (k == needle.length()) {
                return haystack.substring(i, haystack.length());
            }
        }
        
        return null;
    }
}