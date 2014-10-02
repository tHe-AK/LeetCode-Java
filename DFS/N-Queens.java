public class Solution {
    public List<String[]> solveNQueens(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        List<String[]> result = new ArrayList<String[]>();
        
        helper(n, new int[n], 0, result);
        
        return result;
    }
    
    private void helper(int n, int[] rec, int cur, List<String[]> result) {
        if (cur == n) {
            String[] str = new String[n];
            
            for (int i = 0; i < n; i++) {
                str[i] = "";
                
                for (int j = 0; j < n; j++) {
                    if (rec[i] == j) {
                        str[i] += "Q";
                    }
                    else {
                        str[i] += ".";
                    }
                }
            }
            
            result.add(str);
            return;
        }
        
        for (int j = 0; j < n; j++) {
            int i;
            
            for (i = 0; i < cur; i++) {
                if (j == rec[i] || cur - i == Math.abs(j - rec[i])) {
                    break;
                }
            }
            
            if (i == cur) {               
                rec[cur] = j;
                helper(n, rec, cur + 1, result);
            }
        }
    }
}