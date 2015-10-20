public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null) {
            throw new IllegalArgumentException();
        }
        
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        int[] offsetX = new int[] {0, 0, -1, 1};
        int[] offsetY = new int[] {-1, 1, 0, 0};
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int preX = peek[0];
            int preY = peek[1];

            for (int i = 0; i < offsetX.length; i++) {
                int x = preX + offsetX[i];
                int y = preY + offsetY[i];
                
                if (x >= 0 && x < row && y >= 0 && y < col && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[preX][preY] + 1;
                    queue.offer(new int[] {x, y});
                }
            }
        }
    }
}
