public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException();
        }
        
        int len = 9;
        boolean[][] row = new boolean[len][len];
        boolean[][] col = new boolean[len][len];
        boolean[][] sq = new boolean[len][len];
        List<Integer> path = new ArrayList<Integer>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    sq[i / 3 * 3 + j / 3][num] = true;
                }
                else {
                    path.add(i * 9 + j);
                }
            }
        }
        
        helper(board, row, col, sq, path, 0);
    }
    
    private boolean helper(char[][] board, boolean[][] row, boolean[][] col, boolean[][] sq, List<Integer> path, int cur) {
        if (cur == path.size()) {
            return true;
        }
        
        int val = path.get(cur);
        int i = val / 9;
        int j = val % 9;
        int index = i / 3 * 3 + j / 3;
        
        for (int k = 0; k < 9; k++) {
            if (!row[i][k] && !col[j][k] && !sq[index][k]) {
                row[i][k] = true;
                col[j][k] = true;
                sq[index][k] = true;
                board[i][j] = (char)('1' + k);
                    
                if (helper(board, row, col, sq, path, cur + 1)) {
                    return true;
                }
                    
                row[i][k] = false;
                col[j][k] = false;
                sq[index][k] = false;
            }
        }
        
        return false;
    }
}