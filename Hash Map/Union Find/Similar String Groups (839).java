class UnionFind {
    private Map<Integer, Integer> map;
    private int size;
    
    public UnionFind() {
        map = new HashMap<>();
        size = 0;
    }
    
    public void insert(int i) {
        map.put(i, i);
        size++;
    }
    
    public int find(int child) {
        int parent = child;
        
        while (parent != map.get(parent)) {
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
            size--;
        }
    }
    
    public int size() {
        return size;
    }
}

public class Solution {
    public int numSimilarGroups(String[] A) {
        int N = A.length;
        UnionFind uf = new UnionFind();
        
        for (int i = 0; i < N; i++) {
            uf.insert(i);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (areSimilar(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.size();
    }
    
    private boolean areSimilar(String s1, String s2) {
        int diff = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
}

class Solution {
    public int numSimilarGroups(String[] A) {
        int N = A.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(A, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(String[] A, int i, boolean[] visited) {
        visited[i] = true;
        
        for (int j = 0; j < A.length; j++) {
            if (!visited[j] && areSimilar(A[i], A[j])) {
                dfs(A, j, visited);
            }
        }
    }
    
    private boolean areSimilar(String s1, String s2) {
        int diff = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
}
