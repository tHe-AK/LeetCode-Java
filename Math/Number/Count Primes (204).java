public class Solution {
    public int countPrimes(int n) {
        boolean[] rec = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (!rec[i]) {
                count++;
                
                for (int j = i; j < n; j += i) {
                    rec[j] = true;
                }
            }
        }
        
        return count;
    }
}
