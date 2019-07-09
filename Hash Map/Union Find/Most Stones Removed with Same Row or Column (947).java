class UnionFind {
    private Map<Integer, Integer> map;
    private int count;
    
    public UnionFind() {
        map = new HashMap<>();
        count = 0;
    }

    private int find(int child) {
        if (!map.containsKey(child)) {
            map.put(child, child);
            count++;
        }
        
        int parent = child;
        
        while (map.get(parent) != parent) {
            parent = map.get(parent);
        }
        
        map.put(child, parent);
        return parent;
    }
    
    public void union(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);
        
        if (parent1 != parent2) {
            map.put(parent1, parent2);
            count--;
        }
    }
    
    public int getCount() {
        return count;
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        
        for (int[] stone : stones) {
            uf.union(stone[0], ~stone[1]);
        }
        
        return stones.length - uf.getCount();
    }
}
