public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length < 0) {
            throw new IllegalArgumentException();
        }
        
        int n = values.length;
        
        if (n == 0) {
            return false;
        }
        
        if (n <= 2) {
            return true;
        }
        
        int sum = 0;
        
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        
        int[] rec = new int[n + 1];
        rec[n] = values[n - 1];
        rec[n - 1] = values[n - 1] + values[n - 2];
        
        for (int i = n - 2; i >= 1; i--) {
            rec[i] = Math.max(values[i - 1] - rec[i + 1], values[i - 1] + values[i] - rec[i + 2]);
        }
        
        return rec[1] > 0;
    }
}
