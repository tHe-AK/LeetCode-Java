class UnionFind {
    public int[] map;
    
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
        
        if (parent1 != parent2) {
            map[parent1] = parent2;
        }
    }
}

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
                        
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && uf.find(equation.charAt(0) - 'a') == uf.find(equation.charAt(3) - 'a')) {
                return false;
            }
        }
                
        return true;
    }
}
