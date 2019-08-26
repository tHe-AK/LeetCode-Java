class UnionFind {
    private int[] map;
    private int count;
    
    public UnionFind(int N) {
        map = new int[N];
        count = N;
        
        for (int i = 0; i < N; i++) {
            map[i] = i;
        }
    }
    
    private int find(int child) {
        int parent = child;
        
        while (parent != map[parent]) {
            parent = map[parent];
        }
        
        map[child] = parent;
        return parent;
    }
    
    public void merge(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            map[parent1] = parent2;
            count--;
        }
    }
    
    public int getCount() {
        return count;
    }
}

public class Solution {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(N);
        
        for (int[] log : logs) {
            uf.merge(log[1], log[2]);
            
            if (uf.getCount() == 1) {
                return log[0];
            }
        }
        
        return -1;
    }
}
