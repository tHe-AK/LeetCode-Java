public class Solution {
    public String strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        
        if (len2 == 0) {
            return haystack;
        }
        
        if (len2 > len1) {
            return null;
        }
        
        int i;
        for (i = 0; i < len1 - len2 + 1; i++) {
            if (haystack.substring(i).startsWith(needle)) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}
