/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

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
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (n == 0 || m == 0 || operators == null || operators.length == 0) {
            return result;
        }
        
        UnionFind uf = new UnionFind();

        for (Point p : operators) {
            int i = p.x;
            int j = p.y;
            
            int cur = id(i, j, m);
            uf.add(cur);
    
            int neighbor;
                    
            if (valid(i - 1, j, n, m)) {
                neighbor = id(i - 1, j, m);
                        
                if (uf.contain(neighbor)) {
                    uf.union(cur, neighbor);
                }
            }
                    
            if (valid(i + 1, j, n, m)) {
                neighbor = id(i + 1, j, m);
                        
                if (uf.contain(neighbor)) {
                    uf.union(cur, neighbor);
                    }
                }
                    
            if (valid(i, j - 1, n, m)) {
                neighbor = id(i, j - 1, m);
                        
                if (uf.contain(neighbor)) {
                    uf.union(cur, neighbor);
                }
            }
                    
            if (valid(i, j + 1, n, m)) {
                neighbor = id(i, j + 1, m);
                        
                if (uf.contain(neighbor)) {
                    uf.union(cur, neighbor);
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
