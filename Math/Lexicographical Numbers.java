public class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int cur = 1;
        
        for (int i = 1; i <= n; i++) {
            result.add(cur);
            
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
        }
        
        return result;
     }
}
