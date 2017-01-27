public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException();
        }
        
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(i, j, grid);
                    num++;
                }
            }
        }
        
        return num;
    }
    
    private void helper(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        helper(i - 1, j, grid);
        helper(i + 1, j, grid);
        helper(i, j - 1, grid);
        helper(i, j + 1, grid);
    }
}

class UnionFind {
    HashMap<Integer, Integer> rec;
    int count;
    
    UnionFind() {
        rec = new HashMap<Integer, Integer>();
        count = 0;
    }
    
    boolean contains(int child) {
        return rec.containsKey(child);
    }
    
    void add(int child) {
        if (!contains(child)) {
            rec.put(child, child);
            count++;
        }
    }
    
    int find(int child) {
        if (!contains(child)) {
            throw new RuntimeException();
        }
        
        while (child != rec.get(child)) {
            child = rec.get(child);
        }
            
        return child;
    }
    
    void union(int child1, int child2) {
        if (!contains(child1) || !contains(child2)) {
            return;
        }
        
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            rec.put(parent1, parent2);
            count--;
        }
    }
}

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException();
        }
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        UnionFind uf = new UnionFind();
        int row = grid.length;
        int col = grid[0].length;
        int[] x = new int[] {-1, 1, 0, 0};
        int[] y = new int[] {0, 0, -1, 1};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    int cur = id(i, j, col);
                    uf.add(cur);
    
                    for (int k = 0; k < x.length; k++) {
                        if (valid(i + x[k], j + y[k], row, col)) {
                            int neighbor = id(i + x[k], j + y[k], col);
                            uf.union(cur, neighbor);
                        } 
                    }
                }
            }
        }
        
        return uf.count;
    }
    
    private int id(int i, int j, int col) {
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
