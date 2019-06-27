class Solution {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        Map<Integer, Long> map = new TreeMap<>();
        long count = 0;
        
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0L) + 1);
        }
        
        Integer[] list = map.keySet().toArray(new Integer[0]);
        
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                int x = list[i];
                int y = list[j];
                int z = target - x - y;
                                
                if (y <= z && map.containsKey(z)) {
                    long countX = map.get(x);
                    long countY = map.get(y);
                    long countZ = map.get(z);
                    
                    if (x == y && y == z) {
                        count += countX * (countX - 1) * (countX - 2) / 6 % MOD;
                    } else if (x == y) {
                        count += countX * (countX - 1) / 2 * countZ % MOD;
                    } else if (y == z) {
                        count += countX * countY * (countY - 1) / 2 % MOD;
                    } else {
                        count += countX * countY * countZ % MOD;
                    }
                    
                    count %= MOD;
                }
            }
        }
        
        return (int) count;
    }
}
