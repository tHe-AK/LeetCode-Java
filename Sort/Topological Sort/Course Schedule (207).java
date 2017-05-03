public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] rec = new List[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            rec[i] = new ArrayList<>();
        }
        
        for (int[] pre : prerequisites) {
            rec[pre[1]].add(pre[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(rec, i, new boolean[numCourses])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<Integer>[] rec, int i, boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        
        visited[i] = true;
        
        for (int j : rec[i]) {
            if (!dfs(rec, j, visited)) {
                return false;
            }
        }
        
        visited[i] = false;
        return true;
    }
}
