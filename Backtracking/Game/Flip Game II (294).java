public class Solution {
    public boolean canWin(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String str = s.substring(0, i) + "--" + s.substring(i + 2);
                
                if (!canWin(str)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
