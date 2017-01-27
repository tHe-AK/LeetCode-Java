public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> rec = new ArrayList<List<Integer>>(numCourses);
        
        for (int i = 0; i < numCourses; i++) {
            rec.add(new ArrayList<Integer>());
        }
        
        for (int[] pair : prerequisites) {
            rec.get(pair[1]).add(pair[0]);
        }
        
        List<Integer> reverse = new ArrayList<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (!helper(rec, i, new boolean[numCourses], reverse)) {
                return new int[0];
            }
        }
        
        int[] result = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            result[i] = reverse.get(numCourses - i - 1);
        }
        
        return result;
    }
    
    private boolean helper(List<List<Integer>> rec, int i, boolean[] path, List<Integer> reverse) {
        if (path[i]) {
            return false;
        }
        
        if (reverse.contains(i)) {
            return true;
        }
        
        path[i] = true;
        
        for (Integer j : rec.get(i)) {
            if (!helper(rec, j, path, reverse)) {
                return false;
            }
        }
        
        path[i] = false;
        reverse.add(i);
        
        return true;
    }
}
