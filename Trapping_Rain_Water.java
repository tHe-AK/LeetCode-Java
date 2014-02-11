public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        int water = 0;
        if (len < 2) {
            return water;
        }
    
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = -1;
        right[len - 1] = -1;
        
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], A[i - 1]);
        }
        for (int j = len - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], A[j + 1]);
        }
        
        for (int i = 0; i < len; i++) {
            int diff = Math.min(left[i], right[i]) - A[i];
            if (diff > 0) {
                water += diff;
            }
        }
        
        return water;
    }
}
