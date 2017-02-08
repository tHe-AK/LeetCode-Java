public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        return helper(x) + helper(y);
    }
    
    private int helper(List<Integer> list) {
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
