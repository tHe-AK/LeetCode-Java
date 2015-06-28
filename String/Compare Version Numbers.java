public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new IllegalArgumentException();
        }
        
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        
        while (i < str1.length || i < str2.length) {
            if (i < str1.length && i < str2.length) {
                int val1 = Integer.parseInt(str1[i]);
                int val2 = Integer.parseInt(str2[i]);
                
                if (val1 < val2) {
                    return -1;
                }
                else if (val1 > val2) {
                    return 1;
                }
                else {
                }
            }
            else if (i < str1.length) {
                int val1 = Integer.parseInt(str1[i]);
                
                if (val1 != 0) {
                    return 1;
                }
            }
            else {
                int val2 = Integer.parseInt(str2[i]);
                
                if (val2 != 0) {
                    return -1;
                }
            }
            
            i++;
        }
        
        return 0;
    }
}
