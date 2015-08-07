class UnionFind {
    HashMap<Integer, Integer> rec;
    int count;
    
    UnionFind() {
        rec = new HashMap<Integer, Integer>();
        count = 0;
    }
    
    boolean contain(int child) {
        return rec.containsKey(child);
    }
    
    void add(int child) {
        if (!contain(child)) {
            rec.put(child, child);
            count++;
        }
    }
    
    int find(int child) {
        if (!contain(child)) {
            throw new RuntimeException();
        }
        
        while (child != rec.get(child)) {
            child = rec.get(child);
        }
            
        return child;
    }
    
    void union(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            rec.put(parent1, parent2);
            count--;
        }
    }
}

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        UnionFind uf = new UnionFind();
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    int cur = helper(i, j, col);
                    uf.add(cur);
    
                    int neighbor;
                    
                    if (valid(i - 1, j, row, col)) {
                        neighbor = helper(i - 1, j, col);
                        
                        if (uf.contain(neighbor)) {
                            uf.union(cur, neighbor);
                        }
                    }
                    
                    if (valid(i + 1, j, row, col)) {
                        neighbor = helper(i + 1, j, col);
                        
                        if (uf.contain(neighbor)) {
                            uf.union(cur, neighbor);
                        }
                    }
                    
                    if (valid(i, j - 1, row, col)) {
                        neighbor = helper(i, j - 1, col);
                        
                        if (uf.contain(neighbor)) {
                            uf.union(cur, neighbor);
                        }
                    }
                    
                    if (valid(i, j + 1, row, col)) {
                        neighbor = helper(i, j + 1, col);
                        
                        if (uf.contain(neighbor)) {
                            uf.union(cur, neighbor);
                        }
                    }
                }
            }
        }
        
        return uf.count;
    }
    
    private int helper(int i, int j, int col) {
        return i * col + j;
    }
    
    private boolean valid(int i, int j, int row, int col) {
        if (i >= 0 && i < row && j >= 0 && j < col) {
            return true;
        }
        else {
            return false;
        }
    }
}
