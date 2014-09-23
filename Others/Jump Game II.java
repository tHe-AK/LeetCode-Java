public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int max = A[0];
        int cur = 0;
        int step = 0;
        
        for (int i = 1; i < A.length; i++) {
            if (max < i) {
                return -1;
            }
            
            if (cur < i) {
                cur = max;
                step++;
            }
            
            max = Math.max(max, i + A[i]);
        }
        
        return step;
    }
}
