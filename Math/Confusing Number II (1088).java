class Solution {
    public int confusingNumberII(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8); 
        return dfs(0, N, map);
    }
    
    private int dfs(long i, int N, Map<Integer, Integer> map) {
        if (i > N) {
            return 0;
        }
        
        int sum = 0;
        
        if (isValid(i, map)) {
            sum++;    
        }
        
        for (Integer key : map.keySet()) {
            if (key != 0 || i != 0) {
                sum += dfs(i * 10 + key, N, map);
            }
        }
        
        return sum;
    }
    
    private boolean isValid(long N, Map<Integer, Integer> map) {
        long num = N;
        long res = 0;
        
        while (num > 0) {
            res = res * 10 + map.get((int) (num % 10));
            num /= 10;
        }
        
        return N != res;
    }
}
