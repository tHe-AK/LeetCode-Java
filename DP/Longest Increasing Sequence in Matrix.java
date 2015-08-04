public class Solution {
    public List<Integer> longest_seq(int[][] mat) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return result;
        }
        
        int max = 1;
        int start = mat[0][0];
        int x = mat.length;
        int y = mat[0].length;
        int[][] rec = new int[x][y];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int len = helper(mat, rec, i, j);
                if (max < len) {
                    max = len;
                    start = mat[i][j];
                }
            }
        }
        
        for (int i = 0; i < max; i++) {
            result.add(start + i);
        }
        
        return result;
    }
    
    private int helper(int[][] mat, int[][] rec, int i, int j) {
        if (rec[i][j] > 0) {
            return rec[i][j];
        }
        
        if (valid(mat, i - 1, j) && mat[i][j] + 1 == mat[i - 1][j]) {
            rec[i][j] = Math.max(rec[i][j], helper(mat, rec, i - 1, j));
        }
        
        if (valid(mat, i + 1, j) && mat[i][j] + 1 == mat[i + 1][j]) {
            rec[i][j] = Math.max(rec[i][j], helper(mat, rec, i + 1, j));
        }
        
        if (valid(mat, i, j - 1) && mat[i][j] + 1 == mat[i][j - 1]) {
            rec[i][j] = Math.max(rec[i][j], helper(mat, rec, i, j - 1));
        }
        
        if (valid(mat, i, j + 1) && mat[i][j] + 1 == mat[i][j + 1]) {
            rec[i][j] = Math.max(rec[i][j], helper(mat, rec, i, j + 1));
        }
        
        return ++rec[i][j];
    }
    
    private boolean valid(int[][] mat, int i, int j) {
        if (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length) {
            return true;
        }
        else {
            return false;
        }
    }
}
