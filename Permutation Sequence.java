public class Solution {
    public String getPermutation(int n, int k) {
        if (n < 1) {
            return "";
        }
        
        int[] factorial = new int[n];
        factorial[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            factorial[i] = factorial[i + 1] * (n - i - 1);
        }
        
        char[] rec = new char[n];
        boolean[] flag = new boolean[n];
        k--;
        for (int i = 0; i < n; i++) {
            int cur = k / factorial[i];
            k %= factorial[i];
            for (int j = 0; j < n; j++) {
                if (flag[j] == false) {
                    if (cur == 0) {
                        flag[j] = true;
                        rec[i] = (char) ('1' + j);
                        break;
                    }
                    else {
                        cur--;
                    }
                }
            }
        }
        
        return String.valueOf(rec);
    }
}
