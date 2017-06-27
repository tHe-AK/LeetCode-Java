public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        
        int len1 = haystack.length();
        int len2 = needle.length();
        
        for (int i = 0; i < len1 - len2 + 1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (j == len2) {
                    return i;
                } else {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
            }
        }
        
        return -1;
    }
}

public class Solution {
    public int strStr(String haystack, String needle) {       
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                
                if (i + j == haystack.length()) {
                    return -1;
                }
                
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}
