public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] rec = new int[n];
        int count = n;
        
        for (int i = 0; i < n; i++) {
            rec[i] = i;
        }
        
        for (int[] edge : edges) {
            int parent1 = find(rec, edge[0]);
            int parent2 = find(rec, edge[1]);
            
            if (parent1 != parent2) {
                count--;
                rec[parent1] = parent2;
            }
        }
        
        return count;
    }
    
    private int find(int[] rec, int child) {
        int parent = child;
        
        while (parent != rec[parent]) {
            parent = rec[parent];
        }
                                                        
        rec[child] = parent;
        
        return parent;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(list, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(List<List<Integer>> list, int i, boolean[] visited) {
        visited[i] = true;
        
        for (int j : list.get(i)) {
            if (!visited[j]) {
                dfs(list, j, visited);
            }
        }
    }
}
