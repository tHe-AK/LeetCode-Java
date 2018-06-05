public class Solution {
	public int numDistinctIslands2(int[][] grid) {
		Set<String> set = new HashSet<>();
        int[][] delta = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> path = new ArrayList<>();
                    dfs(grid, i, j, path, delta);
                    set.add(sort(path, col));
                }
            }
        }

        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, List<Integer> path, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        
        path.add(i * grid[0].length + j);
        grid[i][j] = 0;

        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            dfs(grid, x, y, path, delta);
        }
    }
    
    private String sort(List<Integer> path, int col) {
    	String candidate = "";
    	int[][] delta = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }};
    	
    	for (int k = 0; k < 7; k++) {
    		List<Integer> list = new ArrayList<>();
    		
    		for (Integer idx : path) {
	    		int i = idx / col;
	    		int j = idx % col;
	    		int x = (k < 4 ? i : j) * delta[k % 4][0];
	    		int y = (k < 4 ? i : j) * delta[k % 4][1];
	    		list.add(x * col + y);
    		}
    		
    		Collections.sort(list);
    		int min = list.get(0);
    		
    		for (int i = 0; i < list.size(); i++) {
    			list.set(i, list.get(i) - min);
    		}
    		
    		String str = list.toString();
    		
    		if (candidate.compareTo(list.toString()) < 0) {
    			candidate = str;
    		}
    	}
    	
    	return candidate;
    }
}
