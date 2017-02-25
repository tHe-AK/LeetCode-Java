public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        long curr = 1;
        result.add(1);
        
        for (int i = 2; i <= n; i++) {
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr += 1;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                
                curr = curr / 10 + 1;
            }
            
            result.add((int) curr);
        }
        
        return result;
    }
}

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(0, n, result);
        
        return result;
    }
    
    private void dfs(long curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }
        
        if (curr != 0) {
            result.add((int) curr);
            dfs(curr * 10, n, result);
        }
        
        if (curr % 10 != 9) {
            dfs(curr + 1, n, result);
        }
    }
}

