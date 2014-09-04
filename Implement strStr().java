public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return null;
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = i;
            int k;
            for (k = 0; k < needle.length(); j++, k++) {
                if (haystack.charAt(j) != needle.charAt(k)) {
                    break;
                }
            }
            
            if (k == needle.length()) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}
