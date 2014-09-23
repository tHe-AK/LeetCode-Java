public class Solution {
    public List<String[]> solveNQueens(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        List<String[]> result = new ArrayList<String[]>();
        
        helper(n, 0, new int[n], result);
        
        return result;
    }
    
    private void helper(int n, int row, int[] rec, List<String[]> result) {
        if (row == n) {
            String[] solution = new String[n];
            
            for (int i = 0; i < n; i++) {
                String str = "";
                
                for (int j = 0; j < n; j++) {
                    if (rec[i] == j) {
                        str += "Q";
                    }
                    else {
                        str += ".";
                    }
                }
                
                solution[i] = str;
            }
            
            result.add(solution);
            return;
        }
        
        for (int j = 0; j < n; j++) {
            int i;
            for (i = 0; i < row; i++) {
                if (rec[i] == j || row - i == Math.abs(j - rec[i])) {
                    break;
                }
            }
            
            if (i == row) {
                rec[row] = j;
                helper(n, row + 1, rec, result);
            }
        }
    }
}
