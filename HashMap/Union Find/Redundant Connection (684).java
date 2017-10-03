class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rec = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            rec[i] = i;
        }
        
        for (int[] edge : edges) {
            int parent1 = find(rec, edge[0]);
            int parent2 = find(rec, edge[1]);
            
            if (parent1 == parent2) {
                return edge;
            }
            
            rec[parent2] = parent1;
        }
        
        return null;
    }
    
    private int find(int[] rec, int child) {
        int parent = child;
        
        while (rec[parent] != parent) {
            parent = rec[parent];
        }
        
        rec[child] = parent;
        return parent;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] rec = new List[n + 1];
        
        for (int i = 1; i <= n; i++) {
            rec[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            
            if (dfs(rec, i, j, new boolean[n + 1])) {
                return edge;
            }
            
            rec[i].add(j);
            rec[j].add(i);
        }
        
        return null;
    }
    
    private boolean dfs(List<Integer>[] rec, int i, int j, boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        
        if (i == j) {
            return true;
        }
        
        visited[i] = true;
        
        for (int val : rec[i]) {
            if (dfs(rec, val, j, visited)) {
                return true;
            }
        }
        
        return false;
    }
}
