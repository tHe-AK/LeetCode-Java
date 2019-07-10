class UnionFind {
    int[] map;
    int[] count;
    
    public UnionFind(int N) {
        map = new int[N];
        count = new int[N];
        
        for (int i = 0; i < N; i++) {
            map[i] = i;
            count[i] = 1;
        }
    }
    
    private int find(int child) {
        int parent = child;
        
        while (map[parent] != parent) {
            parent = map[parent];
        }
        
        map[child] = parent;
        return parent;
    }
    
    public void union(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            map[parent1] = parent2;
            count[parent2] += count[parent1];
            count[parent1] = 0;
        }
    }
    
    public int getMaxCount() {
        int max = 0;
        
        for (int i : count) {
            max = Math.max(max, i);
        }
        
        return max;
    }
}

public class Solution {
    public int largestComponentSize(int[] A) {
        int N = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(N);
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    if (j != 1) {
                        if (map.containsKey(j)) {
                            uf.union(map.get(j), i);
                        } else {
                            map.put(j, i);
                        }
                    }
                    
                    if (map.containsKey(A[i] / j)) {
                        uf.union(map.get(A[i] / j), i);
                    } else {
                        map.put(A[i] / j, i);
                    }
                }
            }
        }
        
        return uf.getMaxCount();
    }
}
