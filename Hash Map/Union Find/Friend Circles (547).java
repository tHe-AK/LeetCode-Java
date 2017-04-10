public class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] count = new int[1];
        count[0] = len;
        int[] idx = new int[len];
        
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    union(idx, i, j, count);
                }
            }
        }
        
        return count[0];
    }

    private void union(int[] idx, int i, int j, int[] count) {
        int parent1 = find(idx, i);
        int parent2 = find(idx, j);
        
        if (parent1 != parent2) {
            idx[parent1] = parent2;
            count[0]--;
        }
    }
    
        
    private int find(int[] idx, int i) {
        int parent = i;
        
        while (idx[parent] != parent) {
            parent = idx[parent];
        }
        
        idx[i] = parent;
        return parent;
    }
}

public class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }
}

public class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    
                    for (int j = 0; j < len; j++) {
                        if (M[k][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
                
                count++;
            }
        }
        
        return count;
    }
}
