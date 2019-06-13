class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int start = 0;
        int x = 0;
        int y = 1;
        int count = 1;

        while (start < res.length) {            
            for (int i = 0; i < count; i++) {
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    res[start++] = new int[] { r0, c0 };
                }
                
                r0 += x;
                c0 += y;
            }
            
            int temp = x;
            x = y;
            y = -temp;
            
            if ((x == 0 && y == -1) || (x == 0 && y == 1)) {
                count++;
            }
        }
        
        return res;
    }
}
