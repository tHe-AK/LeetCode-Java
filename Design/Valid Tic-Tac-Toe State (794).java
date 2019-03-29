class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0;
        int antidiagonal = 0;
        int count = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char ch = board[i].charAt(j);

                if (ch == 'X') {
                    count++;
                    rows[i]++;
                    cols[j]++;

                    if (i == j) {
                        diagonal++;
                    }

                    if (i + j == 2) {
                        antidiagonal++;
                    }
                } else if (ch == 'O') {
                    count--;
                    rows[i]--;
                    cols[j]--;

                    if (i == j) {
                        diagonal--;
                    }

                    if (i + j == 2) {
                        antidiagonal--;
                    }
                }
            }
        }
        
        boolean winX = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 || cols[0] == 3 || cols[1] == 3 || cols[2] == 3 || diagonal == 3 || antidiagonal == 3;
        boolean winO = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 || cols[0] == -3 || cols[1] == -3 || cols[2] == -3 || diagonal == -3 || antidiagonal == -3;
        
        if ((winX && !winO && count == 1) || (!winX && winO && count == 0) || (!winX && !winO && (count == 0 || count == 1))) {
            return true;
        } else {
            return false;
        }
    }
}
