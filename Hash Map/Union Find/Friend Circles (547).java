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
    
    public void dfs(int[][] M, int i, boolean[] visited) {
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
