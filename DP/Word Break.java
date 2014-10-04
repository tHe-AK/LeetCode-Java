public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            throw new IllegalArgumentException();
        }
        
        if (s.length() == 0) {
            return false;
        }
        
        int len = s.length();
        boolean[] rec = new boolean[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if ((j == 0 || rec[j - 1]) && dict.contains(s.substring(j, i + 1))) {
                    rec[i] = true;
                    break;
                }
            }
        }
        
        return rec[len - 1];
    }
}