class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        
        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        
        visited[i] = true;
        
        for (Integer j : rooms.get(i)) {
            dfs(rooms, j, visited);
        }
    }
}
