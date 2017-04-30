public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int i = 0;
        
        while (i < strs1.length || i < strs2.length) {
            int num1 = i < strs1.length ? Integer.parseInt(strs1[i]) : 0;
            int num2 = i < strs2.length ? Integer.parseInt(strs2[i]) : 0;
            
            if (num1 != num2) {
                return Integer.compare(num1, num2);
            }
            
            i++;
        }
        
        return 0;
    }
}
