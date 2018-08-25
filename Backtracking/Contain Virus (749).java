class Solution {
    public int containVirus(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Set<Integer> walls = new HashSet<>();
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        while (true) {
            List<Map<Integer, Set<Integer>>> list = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1 && !visited.contains(getIdx(i, j, col))) {
                        Map<Integer, Set<Integer>> frontiers = new HashMap<>();
                        dfs(grid, i, j, -1, frontiers, visited, walls, delta);

                        if (!frontiers.isEmpty()) {
                            list.add(frontiers);
                        }
                    }
                }
            }
            
            if (list.isEmpty()) {
                break;
            }
            
            int max = list.get(0).size();
            int maxIdx = 0;
            
            for (int i = 1; i < list.size(); i++) {
                int size = list.get(i).size();
                
                if (size > max) {
                    max = size;
                    maxIdx = i;
                }
            }
            
            Map<Integer, Set<Integer>> newWalls = list.remove(maxIdx);
            
            for (Integer key : newWalls.keySet()) {
                Set<Integer> val = newWalls.get(key);
                walls.addAll(val);
                count += val.size();
            }
            
            for (Map<Integer, Set<Integer>> map : list) {
                for (Integer idx : map.keySet()) {
                    int i = getX(idx, col);
                    int j = getY(idx, col);
                    grid[i][j] = 1;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j, int prevIdx, Map<Integer, Set<Integer>> frontiers, Set<Integer> visited, Set<Integer> walls, int[][] delta) {
        int idx = getIdx(i, j, grid[0].length);
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited.contains(idx) || walls.contains(idx)) {
            return;
        }
        
        if (grid[i][j] == 0) {
            frontiers.putIfAbsent(idx, new HashSet<>());
            frontiers.get(idx).add(prevIdx);
            return;
        }
        
        visited.add(idx);
        
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            dfs(grid, x, y, idx, frontiers, visited, walls, delta);
        }
    }
        
    private int getIdx(int i, int j, int col) {
        return i * col + j;
    }
                    
    private int getX(int idx, int col) {
        return idx / col;
    }
                    
    private int getY(int idx, int col) {
        return idx % col;
    }
}
