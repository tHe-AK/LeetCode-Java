class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String key = Arrays.toString(cells);

            if (map.containsKey(key)) {
                int prev = map.get(key);
                return list.get(prev + (N - prev) % (i - prev));
            }
            
            map.put(key, i);
            list.add(cells);
            int[] next = new int[cells.length];
            
            for (int j = 1; j < cells.length - 1; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    next[j] = 1;
                }
            }
            
            cells = next;
        }
        
        return cells;
    }
}
