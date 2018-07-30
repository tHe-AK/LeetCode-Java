/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }
    
    private Node construct(int[][] grid, int x, int y, int size) {
        int val = grid[x][y];
        boolean isLeaf = true;
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }
        
        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        } else {
            size /= 2;
            Node topLeft = construct(grid, x, y, size);
            Node topRight = construct(grid, x, y + size, size);
            Node bottomLeft = construct(grid, x + size, y, size);
            Node bottomRight = construct(grid, x + size, y + size, size);
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
