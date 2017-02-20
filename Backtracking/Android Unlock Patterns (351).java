public class Solution {
    public int numberOfPatterns(int m, int n) {
        int result = 0;
        int[] idx = { 0, 1, 4 };
        boolean[] visited = new boolean[9];
        
        for (int len = m; len <= n; len++) {
            for (int i : idx) {
                visited[i] = true;
                result += (i == 4 ? 1 : 4) * calcPatterns(i, len - 1, visited);
                visited[i] = false;
            }
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
        
        int mid = (curr + prev) / 2;
        
        if (mid == 4) {
            // indexes are at both end of the diagonals for example 0,0, and 8,8          
            return visited[mid];
        } else if ((curr % 3 != prev % 3) && (curr / 3 != prev / 3)) {
            // adjacent cells on diagonal for example 0,0 and 1,1 or 2,0 and 1,1
            return true;
        } else {
            // all other cells which are not adjacent
            return visited[mid];
        }
    }
}
