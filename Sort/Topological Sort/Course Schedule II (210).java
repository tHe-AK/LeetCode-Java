public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> rec = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            rec.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            rec.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(rec, i, new boolean[numCourses], order)) {
                return new int[0];
            }
            
            rec.get(i).clear();
        }
        
        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(numCourses - i - 1);
        }
        
        return result;
    }
    
    private boolean dfs(List<List<Integer>> rec, int i, boolean[] visited, List<Integer> order) {
        if (visited[i]) {
            return false;
        }
        
        if (order.contains(i)) {
            return true;
        }
        
        visited[i] = true;
        
        for (Integer j : rec.get(i)) {
            if (!dfs(rec, j, visited, order)) {
                return false;
            }
        }
        
        visited[i] = false;
        order.add(i);
        
        return true;
    }
}
