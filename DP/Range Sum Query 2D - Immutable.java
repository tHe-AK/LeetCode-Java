public class NumMatrix {
    private int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row + 1][col + 1];
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 >= sum.length - 1 || col1 < 0 || col1 >= sum[0].length - 1 ||
            row2 < 0 || row2 >= sum.length - 1 || col2 < 0 || col2 >= sum[0].length - 1 ||
            row1 > row2 || col1 > col2) {
            throw new IllegalArgumentException();
        }
        
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
