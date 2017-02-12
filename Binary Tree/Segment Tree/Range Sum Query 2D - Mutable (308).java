public class NumMatrix {
    private int[][] sum;
    private int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        this.matrix = matrix;
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row][col + 1];
        
        for (int i = 0; i < row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        
        for (int j = col + 1; j < sum[0].length; j++) {
            sum[row][j] += diff;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = 0;
        
        for (int i = row1; i <= row2; i++) {
            val += sum[i][col2 + 1] - sum[i][col1];
        }
        
        return val;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

class SegmentTreeNode {
    public int x1, y1;
    public int x2, y2;
    public int sum;
    public SegmentTreeNode nw, ne, sw, se;
    
    public SegmentTreeNode(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public SegmentTreeNode(int x1, int y1, int x2, int y2, int sum) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.sum = sum;
    }
}
 
public class NumMatrix {
    private SegmentTreeNode root;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        root = buildTree(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    private SegmentTreeNode buildTree(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return null;
        } else if (x1 == x2 && y1 == y2) {
            return new SegmentTreeNode(x1, y1, x2, y2, matrix[x1][y1]);
        } else {
            int midX = x1 + (x2 - x1) / 2;
            int midY = y1 + (y2 - y1) / 2;
            SegmentTreeNode nw  = buildTree(matrix, x1, y1, midX, midY);
            SegmentTreeNode ne  = buildTree(matrix, x1, midY + 1, midX, y2);
            SegmentTreeNode sw  = buildTree(matrix, midX + 1, y1, x2, midY);
            SegmentTreeNode se  = buildTree(matrix, midX + 1, midY + 1, x2, y2);
            SegmentTreeNode root = new SegmentTreeNode(x1, y1, x2, y2);
            root.sum = (nw != null ? nw.sum : 0) + (ne != null ? ne.sum : 0) + (sw != null ? sw.sum : 0) + (se != null ? se.sum : 0);
            root.nw = nw;
            root.ne = ne;
            root.sw = sw;
            root.se = se;
            
            return root;
        }
    }
    
    public void update(int row, int col, int val) {
        update(root, row, col, val);
    }
    
    private void update(SegmentTreeNode root, int row, int col, int val) {
        if (root.x1 == row && root.y1 == col && root.x2 == row && root.y2 == col) {
            root.sum = val;
        } else {
            int midX = root.x1 + (root.x2 - root.x1) / 2;
            int midY = root.y1 + (root.y2 - root.y1) / 2;
            
            if (row <= midX) {
                if (col <= midY) {
                    update(root.nw, row, col, val);
                } else {
                    update(root.ne, row, col, val);
                }
            } else {
                if (col <= midY) {
                    update(root.sw, row, col, val);
                } else {
                    update(root.se, row, col, val);
                }
            }
            
            root.sum = (root.nw != null ? root.nw.sum : 0) + (root.ne != null ? root.ne.sum : 0) + (root.sw != null ? root.sw.sum : 0) + (root.se != null ? root.se.sum : 0);
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRange(root, row1, col1, row2, col2);
    }
    
    private int sumRange(SegmentTreeNode root, int row1, int col1, int row2, int col2) {
        if (root.x1 == row1 && root.y1 == col1 && root.x2 == row2 && root.y2 == col2) {
            return root.sum;
        } else {
            int midX = root.x1 + (root.x2 - root.x1) / 2;
            int midY = root.y1 + (root.y2 - root.y1) / 2;
            
            if (row1 <= midX) {
                if (col1 <= midY) {
                    if (row2 <= midX) {
                        if (col2 <= midY) {
                            return sumRange(root.nw, row1, col1, row2, col2);
                        } else {
                            return sumRange(root.nw, row1, col1, row2, midY) + sumRange(root.ne, row1, midY + 1, row2, col2);
                        }
                    } else {
                        if (col2 <= midY) {
                            return sumRange(root.nw, row1, col1, midX, col2) + sumRange(root.sw, midX + 1, col1, row2, col2);
                        } else {
                            return sumRange(root.nw, row1, col1, midX, midY) + sumRange(root.ne, row1, midY + 1, midX, col2) + sumRange(root.sw, midX + 1, col1, row2, midY) + sumRange(root.se, midX + 1, midY + 1, row2, col2);
                        }
                    }
                } else {
                    if (row2 <= midX) {
                        return sumRange(root.ne, row1, col1, row2, col2);
                    } else {
                        return sumRange(root.ne, row1, col1, midX, col2) + sumRange(root.se, midX + 1, col1, row2, col2);
                    }
                }
            } else {
                if (col1 <= midY) {
                    if (col2 <= midY) {
                        return sumRange(root.sw, row1, col1, row2, col2); 
                    } else {
                        return sumRange(root.sw, row1, col1, row2, midY) + sumRange(root.se, row1, midY + 1, row2, col2);
                    }
                } else {
                    return sumRange(root.se, row1, col1, row2, col2); 
                }
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
