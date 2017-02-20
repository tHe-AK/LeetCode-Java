public class Solution {
    public int numberOfPatterns(int m, int n) {
        int result = 0;
        
        for (int len = m; len <= n; len++) {                
            result += calcPatterns(-1, len, new boolean[9]);
        }
        
        return result;
    }

    private int calcPatterns(int prev, int len, boolean[] visited) {
        if (len == 0) {
            return 1;  
        }
        
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            if (isValid(i, prev, visited)) {
                visited[i] = true;
                sum += calcPatterns(i, len - 1, visited);
                visited[i] = false;                    
            }
        }
        
        return sum;
    }

    private boolean isValid(int curr, int prev, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }
        
        // first digit of the pattern    
        if (prev == -1) {
            return true;
        }
        
        // knight moves or adjacent cells (in a row or in a column)        
        if ((curr + prev) % 2 == 1) {
            return true;
        }
        
        // indexes are at both end of the diagonals for example 0,0, and 8,8          
        int mid = (curr + prev) / 2;
        
        if (mid == 4) {
            return visited[mid];
        }
        
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and 1,1
        if ((curr % 3 != prev % 3) && (curr / 3 != prev / 3)) {
            return true;
        }
        
        // all other cells which are not adjacent
        return visited[mid];
    }
}
