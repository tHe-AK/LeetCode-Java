public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int dist = matrix.get(peek[0]).get(peek[1]) + 1;
            
            for (int[] diff : delta) {
                int x = peek[0] + diff[0];
                int y = peek[1] + diff[1];
                
                if (x >= 0 && x < m && y >= 0 && y < n && dist < matrix.get(x).get(y)) {
                    matrix.get(x).set(y, dist);
                    queue.add(new int[] { x, y });
                }
            }
        }
        
        return matrix;
    }
}
