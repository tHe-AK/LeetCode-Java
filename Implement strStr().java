public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        
        int len1 = haystack.length();
        int len2 = needle.length();

        if (len2 == 0) {
            return haystack;
        }
        
        if (len2 > len1) {
            return null;
        }
        
        for (int i = 0; i < len1 - len2 + 1; i++) {
            int j = i;
            int k;
            for (k = 0; k < len2; j++, k++) {
                if (haystack.charAt(j) != needle.charAt(k)) {
                    break;
                }
            }
            
            if (k == len2) {
                return haystack.substring(i);
            }
        }
        
        return null;
    }
}

public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        
        int len1 = haystack.length();
        int len2 = needle.length();

        if (len2 == 0) {
            return haystack;
        }
        
        if (len2 > len1) {
            return null;
        }
        
        int[] rec = new int[len2];
        rec[0] = 0;
        int i = 1;
        int j = 0;
        while (i < len2) {
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                rec[i] = j;
                i++;
            }
            else if (j != 0) {
                j = rec[j - 1];
            }
            else {
                rec[i] = 0;
                i++;
            }
        }
        
        i = 0;
        j = 0;
        while (i < len1) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == len2) {
                    return haystack.substring(i - j);
                }
            }
            else if (j != 0) {
                j = rec[j - 1];
            }
            else {
                i++;
            }
        }
        
        return null;
    }
}
