public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.isEmpty() == true) {
            return dict == null || dict.isEmpty() == true;
        }
        
        int len = s.length();
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if ((j == 0 || flag[j - 1] == true) && dict.contains(s.substring(j, i + 1))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        
        return flag[len - 1];
    }
}
