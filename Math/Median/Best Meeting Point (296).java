public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int[] x = new int[row];
        int[] y = new int[col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    x[i]++;
                    y[j]++;
                }
            }
        }
        
        return getDist(x) + getDist(y);
    }
    
    private int getDist(int[] rec) {
        int dist = 0;
        int i = 0;
        int j = rec.length - 1;
        
        while (i < j) {
            if (rec[i] == 0) {
                i++;
            } else if (rec[j] == 0) {
                j--;
            } else {
                int min = Math.min(rec[i], rec[j]);
                dist += (j - i) * min;
                rec[i] -= min;
                rec[j] -= min;
            }
        }
        
        return dist;
    }
}

public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        return getDist(x) + getDist(y);
    }
    
    private int getDist(List<Integer> list) {
        Collections.sort(list);
        
        int dist = 0;
        int i = 0;
        int j = list.size() - 1;
        
        while (i < j) {
            dist += list.get(j) - list.get(i);
            i++;
            j--;
        }
        
        return dist;
    }
}
