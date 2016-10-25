public class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        long cur = 1;
        result.add((int) cur);
        
        for (int i = 2; i <= n; i++) {
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur += 1;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                
                cur = cur / 10 + 1;
            }
            
            result.add((int) cur);
        }
        
        return result;
    }
}

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        helper(0, n, result);
        
        return result;
    }
    
    private void helper(long cur, int n, List<Integer> result) {
        if (cur > n) {
            return;
        }
        
        if (cur != 0) {
            result.add((int) cur);
            helper(cur * 10, n, result);
        }
        
        if (cur % 10 != 9) {
            helper(cur + 1, n, result);
        }
    }
}

