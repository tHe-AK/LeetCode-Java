public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int max = A[0];
        int pre = 0;
        int step = 0;
        for (int i = 1; i < A.length; i++) {
            if (i > max) {
                return -1;
            }
            
            if (i > pre) {
                step++;
                pre = max;
            }
            
            max = Math.max(max, i + A[i]);
        }
        
        return step;
    }
}
