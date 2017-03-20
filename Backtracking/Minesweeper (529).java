public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int col = click[1];
        
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            
            List<int[]> neighbors = getNeighbors(board, row, col);
            
            for (int[] neighbor : neighbors) {
                if (board[neighbor[0]][neighbor[1]] == 'M') {
                    count++;
                }
            }
            
            if (count > 0) {
                board[row][col] = (char) ('0' + count);
            } else {
                board[row][col] = 'B';
                
                for (int[] neighbor : neighbors) {
                    if (board[neighbor[0]][neighbor[1]] == 'E') {
                        updateBoard(board, neighbor);
                    }
                }
            }
        }
        
        return board;
    }
    
    private List<int[]> getNeighbors(char[][] board, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    int x = row + i;
                    int y = col + j;
                            
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                        neighbors.add(new int[] { x, y });
                    }
                }
            }
        }
        
        return neighbors;
    }
}
