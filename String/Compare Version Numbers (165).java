public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len1 = str1.length;
        int len2 = str2.length;
        int i = 0;

        while (i < len1 || i < len2) {
            Integer val1 = i < len1 ? Integer.parseInt(str1[i]) : 0;
            Integer val2 = i < len2 ? Integer.parseInt(str2[i]) : 0;
            int compare = val1.compareTo(val2);
            
            if (compare != 0) {
                return compare;
            }
            
            i++;
        }
        
        return 0;
    }
}
