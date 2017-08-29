class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
		int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j];
                int count = 1;
                
                for (int[] diff : delta) {
                    int x = i + diff[0];
                    int y = j + diff[1];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += M[x][y];
                        count++;
                    }
                }
                
                res[i][j] = sum / count;
            }
        }
        
        return res;
    }
}
