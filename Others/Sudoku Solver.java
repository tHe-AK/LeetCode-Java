public class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return;
        }
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sq = new boolean[9][9];
        ArrayList<ArrayList<Integer>> rec = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int cur = board[i][j] - '1';
                    row[i][cur] = true;
                    col[j][cur] = true;
                    sq[i / 3 * 3 + j / 3][cur] = true;
                }
                else {
                    ArrayList<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(j);
                    rec.add(pair);
                }
            }
        }
        
        helper(0, rec, board, row, col, sq);
        return;
    }
    
    private boolean helper(int index, ArrayList<ArrayList<Integer>> rec, char[][] board, boolean[][] row, boolean[][] col, boolean[][] sq) {
        if (index == rec.size()) {
            return true;
        }
        
        int i = rec.get(index).get(0);
        int j = rec.get(index).get(1);
        ArrayList<Integer> result = new ArrayList<Integer>();
        valid(i, j, row, col, sq, result);
        
        for (int k = 0; k < result.size(); k++) {
            int cur = result.get(k);
            board[i][j] = (char)('1' + cur);
            row[i][cur] = true;
            col[j][cur] = true;
            sq[i / 3 * 3 + j / 3][cur] = true;
            if (helper(index + 1, rec, board, row, col, sq) == true) {
                return true;
            }
            row[i][cur] = false;
            col[j][cur] = false;
            sq[i / 3 * 3 + j / 3][cur] = false;
        }
        
        return false;
    }
    
    private void valid(int i, int j, boolean[][] row, boolean[][] col, boolean[][] sq, ArrayList<Integer> result) {
        for (int k = 0; k < 9; k++) {
            if (row[i][k] == false && col[j][k] == false && sq[i / 3 * 3 + j / 3][k] == false) {
                result.add(k);
            }
        }
    }
}
