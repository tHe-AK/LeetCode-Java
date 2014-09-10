public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return false;
        }
        
        int len = s.length();
        boolean[] result = new boolean[len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((j == 0 || result[j - 1]) && dict.contains(s.substring(j, i + 1))) {
                    result[i] = true;
                    break;
                }
            }
        }
        
        return result[len - 1];
    }
}
