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
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            rec.put(parent1, parent2);
            count--;
        }
    }
}

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (m < 0 || n < 0 || positions == null) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        UnionFind uf = new UnionFind();
        int[] x = new int[] {-1, 1, 0, 0};
        int[] y = new int[] {0, 0, -1, 1};
        
        for (int[] p : positions) {
            int i = p[0];
            int j = p[1];
            
            int cur = id(i, j, n);
            uf.add(cur);
    
            for (int k = 0; k < x.length; k++) {
                if (valid(i + x[k], j + y[k], m, n)) {
                    int neighbor = id(i + x[k], j + y[k], n);
                    
                    if (uf.contains(neighbor)) {
                        uf.union(cur, neighbor);          
                    }
                } 
            }
            
            result.add(uf.count);
        }
        
        return result;
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
