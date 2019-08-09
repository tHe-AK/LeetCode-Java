class UnionFind {
    private int[] map;
    
    public UnionFind() {
        map = new int[26];
        
        for (int i = 0; i < map.length; i++) {
            map[i] = i;
        }
    }
    
    public int find(int child) {
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
        int min = Math.min(parent1, parent2);
        int max = Math.max(parent1, parent2);
        map[max] = min;
    }
}

public class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        UnionFind uf = new UnionFind();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < A.length(); i++) {
            uf.union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }
        
        for (char ch : S.toCharArray()) {
            sb.append((char) ('a' + uf.find(ch - 'a')));
        }
        
        return sb.toString();
    }
}
