class Solution {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> digits = new ArrayList<>();
        int res = 0;
        
        for (int i = N + 1; i > 0; i /= 10) {
            digits.add(0, i % 10);
        }
        
        int M = digits.size();
        
        for (int i = 1; i < M; i++) {
            res += 9 * helper(9, M - i - 1);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < M; i++) {
            int digit = digits.get(i);
            
            for (int j = i == 0 ? 1 : 0; j < digit; j++) {
                if (!visited.contains(j)) {
                    res += helper(9 - i, M - i - 1);
                }
            }
            
            if (visited.contains(digit)) {
                break;
            }
            
            visited.add(digit);
        }
        
        return N - res;
    }
    
    private int helper(int i, int count) {
        int res = 1;
        
        while (count-- > 0) {
            res *= i;
            i--;
        }
        
        return res;
    }
}
