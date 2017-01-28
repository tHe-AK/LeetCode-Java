public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, delta);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for (int[] diff : delta) {
            dfs(grid, i + diff[0], j + diff[1], delta);
        }
    }
}

class UnionFind<T> {
    private Map<T, T> rec;
    private int count;
    
    public UnionFind() {
        rec = new HashMap<>();
        count = 0;
    }
    
    public int count() {
        return count;
    }
    
    public boolean contains(T child) {
        return rec.containsKey(child);
    }
    
    public void add(T child) {
        if (!contains(child)) {
            rec.put(child, child);
            count++;
        }
    }
    
    public T find(T child) {
        if (!contains(child)) {
            return null;
        }
        
        T root = child;
        
        while (root != rec.get(root)) {
            root = rec.get(root);
        }
        
        rec.put(child, root);
            
        return root;
    }
    
    public void union(T child1, T child2) {
        if (!contains(child1) || !contains(child2)) {
            return;
        }
        
        T root1 = find(child1);
        T root2 = find(child2);
        
        if (root1 != root2) {
            rec.put(root1, root2);
            count--;
        }
    }
}

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        UnionFind uf = new UnionFind();
        int m = grid.length;
        int n = grid[0].length;
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int curr = getIndex(i, j, n);
                    uf.add(curr);
    
                    for (int[] diff : delta) {
                        int x = i + diff[0];
                        int y = j + diff[1];
                        
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            int neighbor = getIndex(x, y, n);
                            uf.union(curr, neighbor);
                        } 
                    }
                }
            }
        }
        
        return uf.count();
    }
    
    private int getIndex(int i, int j, int col) {
        return i * col + j;
    }
}
