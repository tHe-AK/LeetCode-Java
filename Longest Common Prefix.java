public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        
        int i;
        for (i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < len; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
                
            }
        }
        
        return strs[0];
    }
}
