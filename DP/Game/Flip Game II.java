public class Solution {
    public boolean canWin(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
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
