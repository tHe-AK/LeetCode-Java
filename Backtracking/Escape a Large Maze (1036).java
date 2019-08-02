class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int len = blocked.length;
        int N = len * (len - 1) / 2;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Set<String> set = new HashSet<>();
        
        for (int[] idx : blocked) {
            set.add(idx[0] + " " + idx[1]);
        }
        
        return dfs(source[0], source[1], target, set, new HashSet<>(), delta, N) && dfs(target[0], target[1], source, set, new HashSet<>(), delta, N);
    }
    
    private boolean dfs(int i, int j, int[] target, Set<String> blocked, Set<String> visited, int[][] delta, int N) {
        if (i < 0 || i >= 1e6 || j < 0 || j >= 1e6) {
            return false;
        }
        
        if (i == target[0] && j == target[1]) {
            return true;
        }
        
        String idx = i + " " + j;
        
        if (visited.contains(idx) || blocked.contains(idx)) {
            return false;
        }
        
        visited.add(idx);
        
        if (visited.size() > N) {
            return true;
        }
        
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            
            if (dfs(x, y, target, blocked, visited, delta, N)) {
                return true;
            }
        }
        
        return false;
    }
}
