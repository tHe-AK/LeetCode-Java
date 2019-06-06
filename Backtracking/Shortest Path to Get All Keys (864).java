class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int x = -1;
        int y = -1;
        int max = 0;
        int state = 0;
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1} };
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                char ch = grid[i].charAt(j);
                
                if (ch == '@') {
                    x = i;
                    y = j;
                } else if (ch >= 'a' && ch <= 'f') {
                    max = Math.max(max, ch - 'a' + 1);
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[] { x, y, state });
        visited.add(x + " " + y + " " + state);
        int step = 0;
        
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            
            for (int k = 0; k < size; k++) {
                int[] peek = queue.poll();
                x = peek[0];
                y = peek[1];
                state = peek[2];
                
                for (int[] diff : delta) {
                    int i = x + diff[0];
                    int j = y + diff[1];
                    int next = state;
                    
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length()) {
                        continue;
                    }
                    
                    char ch = grid[i].charAt(j);
                        
                    if (ch == '#' || (ch >= 'A' && ch <= 'F' && ((next >> (ch - 'A')) & 1) == 0)) {
                        continue;
                    }
                    
                    if (ch >= 'a' && ch <= 'f') {
                        next |= 1 << (ch - 'a');
                    }
                    
                    if (next == (1 << max) - 1) {
                        return step;
                    }
                    
                    if (visited.add(i + " " + j + " " + next)) {
                        queue.offer(new int[] { i, j, next });
                    }
                }
            }
        }
        
        return -1;
    }
}
