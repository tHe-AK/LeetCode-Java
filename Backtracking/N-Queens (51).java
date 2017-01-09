public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        dfs(n, new int[n], 0, result);
        
        return result;
    }
    
    private void dfs(int n, int[] rec, int row, List<List<String>> result) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[rec[i]] = 'Q';
                list.add(new String(str));
            }
            
            result.add(list);
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (isValid(rec, row, j)) {               
                rec[row] = j;
                dfs(n, rec, row + 1, result);
            }
        }
    }
    
    private boolean isValid(int[] rec, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == rec[i] || row - i == Math.abs(col - rec[i])) {
                return false;
            }
        }
        
        return true;
    }
}
