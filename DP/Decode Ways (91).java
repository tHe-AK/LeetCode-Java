public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        if (n == 0) {
            return 0;
        }
        
        int[] rec = new int[n + 1];
        rec[0] = 1;
        rec[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                rec[i] += rec[i - 1];
            }
            
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                rec[i] += rec[i - 2];
            }
        }
        
        return rec[n];
    }
}
