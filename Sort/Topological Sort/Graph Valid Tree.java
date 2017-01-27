public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 1 || edges == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<Integer>> rec = new ArrayList<List<Integer>>(n);
        
        for (int i = 0; i < n; i++) {
            rec.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            rec.get(edge[0]).add(edge[1]);
            rec.get(edge[1]).add(edge[0]);
        }
        
        boolean[] path = new boolean[n];
        
        if (!helper(rec, 0, -1, path)) {
            return false;
        }
        
        for (int i = 0; i < n; i++) {
            if (!path[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean helper(List<List<Integer>> rec, int i, int parent, boolean[] path) {
        if (path[i]) {
            return false;
        }
        
        path[i] = true;

        for (Integer j : rec.get(i)) {
            if (j != parent && !helper(rec, j, i, path)) {
                return false;
            }
        }
        
        return true;
    }
}
