public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        }
        
        if (n <= 2) {
            return true;
        }
        
        boolean[] rec = new boolean[n + 1];
        rec[1] = true;
        rec[2] = true;
        
        for (int i = 3; i <= n; i++) {
            rec[i] = !(rec[i - 1] && rec[i - 2]);
        }
        
        return rec[n];
    }
}

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        return n % 3 != 0;
    }
}
