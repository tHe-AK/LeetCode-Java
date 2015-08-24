import java.util.Arrays;

public class Solution {
    boolean alibaba(int numCaves, int[] strategy) {
        if (numCaves <= 0 || strategy == null) {
            throw new IllegalArgumentException();
        }
        
        int n = strategy.length;
        boolean[] rec = new boolean[n + 2];
        Arrays.fill(rec, true);
        rec[0] = false;
        rec[n + 1] = false;
        rec[strategy[0]] = false;
        
        for (int k = 1; k < n; k++) {
            boolean pre = rec[0];
            
            for (int i = 1; i <= n; i++) {
                boolean temp = (pre || rec[i + 1]) && strategy[k] != i;
                pre = rec[i];
                rec[i] = temp;
            }
        }
        
        for (int i = 1; i <= n; i++){
            if (rec[i]) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.alibaba(3, new int[] {1, 1}));
    }
}
