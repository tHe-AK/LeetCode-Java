public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
        
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            
            for (int j = 0; j < strs.length; j++) {
                if (i != j) {
                    if (isSubsequence(strs[i], strs[j])) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if (flag) {
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    public boolean isSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            
            j++;
        }
        
        return i == len1;
    }
}
