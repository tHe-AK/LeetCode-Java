class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[][] delta = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }, { 0, 0 } };
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>();
        Map<Integer, Integer> anti = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[] res = new int[queries.length];
        
        for (int[] lamp : lamps) {
            int i = lamp[0];
            int j = lamp[1];
            row.put(i, row.getOrDefault(i, 0) + 1);
            col.put(j, col.getOrDefault(j, 0) + 1);
            diag.put(i - j, diag.getOrDefault(i - j, 0) + 1);
            anti.put(i + j, anti.getOrDefault(i + j, 0) + 1);
            set.add(i * N + j);
        }
        
        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            
            if (row.getOrDefault(i, 0) > 0 || col.getOrDefault(j, 0) > 0 || diag.getOrDefault(i - j, 0) > 0 || anti.getOrDefault(i + j, 0) > 0) {
                res[k] = 1;
                
                for (int[] diff : delta) {
                    int x = i + diff[0];
                    int y = j + diff[1];
                    
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        int idx = x * N + y;
                        
                        if (set.remove(idx)) {                            
                            row.put(x, row.getOrDefault(x, 0) - 1);
                            col.put(y, col.getOrDefault(y, 0) - 1);
                            diag.put(x - y, diag.getOrDefault(x - y, 0) - 1);
                            anti.put(x + y, anti.getOrDefault(x + y, 0) - 1);
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
