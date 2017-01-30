public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> rec = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            rec.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            rec.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(rec, i, new boolean[numCourses])) {
                return false;
            }
            
            rec.get(i).clear();
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> rec, int i, boolean[] visited) {
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        
        for (Integer j : rec.get(i)) {
            if (!dfs(rec, j, visited)) {
                return false;
            }
        }
        
        visited[i] = false;
        
        return true;
    }
}
