public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int step = 0;
        int cur = 0;
        int max = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (i > cur) {
                cur = max;
                step++;
            }
            
            max = Math.max(max, i + A[i]);
        }
        
        return step;
    }
}