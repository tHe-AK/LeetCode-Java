public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        int[] rec = new int[n];
        
        for (int i = 0; i < n; i++) {
            rec[i] = i;
        }
        
        for (int[] edge : edges) {
            int parent1 = find(rec, edge[0]);
            int parent2 = find(rec, edge[1]);
            
            if (parent1 == parent2) {
                return false;
            } else {
                rec[parent1] = parent2;
            }
        }
        
        return true;
    }
    
    int find(int[] rec, int child) {
        int parent = child;
        
        while (parent != rec[parent]) {
            parent = rec[parent];
        }
        
        rec[child] = parent;
        
        return parent;
    }
}

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        List<List<Integer>> rec = new ArrayList<List<Integer>>(n);
        
        for (int i = 0; i < n; i++) {
            rec.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            rec.get(edge[0]).add(edge[1]);
            rec.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!dfs(rec, i, -1, new boolean[n])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> rec, int i, int parent, boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        
        visited[i] = true;

        for (Integer j : rec.get(i)) {
            if (j != parent && !dfs(rec, j, i, visited)) {
                return false;
            }
        }
        
        visited[i] = false;
        return true;
    }
}
