public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int pre1 = 1;
        int pre2 = 2;
        int curr = 3;
        
        for (int i = 3; i <= n; i++) {
            curr = pre1 + pre2;
            pre1 = pre2;
            pre2 = curr;
        }
        
        return curr;
    }
}
