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
            boolean flag = true;
            int j = i;
            for (int k = 0; k < len2; j++, k++) {
                if (haystack.charAt(j) != needle.charAt(k)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}
