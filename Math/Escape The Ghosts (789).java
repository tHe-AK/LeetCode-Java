class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int max = Math.abs(target[0]) + Math.abs(target[1]);
        
        for (int[] ghost : ghosts) {
            int dist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            
            if (dist <= max) {
                return false;
            }
        }
        
        return true;
    }
}
