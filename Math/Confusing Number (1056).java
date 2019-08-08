class Solution {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8); 
        
        int num = N;
        int res = 0;
        
        while (num > 0) {
            int digit = num % 10;
            
            if (!map.containsKey(digit)) {
                return false;
            }
            
            res = res * 10 + map.get(digit);
            num /= 10;
        }
        
        return N != res;
    }
}
