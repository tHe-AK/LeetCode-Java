class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> curr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        
        for (int i = 1; i < N; i++) {
            List<Integer> next = new ArrayList<>();
            
            for (int j : curr) {
                int digit = j % 10;
                
                if (j > 0 && digit + K < 10) {
                    next.add(j * 10 + digit + K);
                }
                    
                if (j > 0 && K > 0 && digit - K >= 0) {
                    next.add(j * 10 + digit - K);
                }
            }
            
            curr = next;
        }
        
        return curr.stream().mapToInt(i -> i).toArray();
    }
}
