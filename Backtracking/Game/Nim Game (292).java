public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

public class Solution {
    public boolean canWinNim(int n) {
        for (int i = 1; i <= 3 && i <= n; i++) {
            if (!canWinNim(n - i)) {
                return true;
            }
        }
        
        return false;
    }
}
