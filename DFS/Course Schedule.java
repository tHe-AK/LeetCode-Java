public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return false;
        }
        
        List<List<Integer>> rec = new ArrayList<List<Integer>>(numCourses);
        
        for (int i = 0; i < numCourses; i++) {
            rec.add(new ArrayList<Integer>());
        }
        
        for (int[] pair : prerequisites) {
            rec.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!helper(rec, i, new boolean[numCourses])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean helper(List<List<Integer>> rec, int i, boolean[] path) {
        if (path[i]) {
            return false;
        }

        path[i] = true;
        
        for (Integer j : rec.get(i)) {
            if (!helper(rec, j, path)) {
                return false;
            }
        }
        
        path[i] = false;
        
        return true;
    }
}
