class Solution {
    public int maxTurbulenceSize(int[] A) {
        int inc = 1;
        int dec = 1;
        int res = 1;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i - 1] < A[i]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            
            res = Math.max(res, Math.max(dec, inc));
        }
        
        return res;
    }
}
