class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] res = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int code : barcodes) {
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        
        for (Integer key : map.keySet()) {
            queue.offer(new int[] { key, map.get(key) });
        }
        
        int i = 0;
        
        while (!queue.isEmpty()) {
            List<int[]> next = new ArrayList<>();
            
            for (int j = 0; j < 2; j++) {
                if (!queue.isEmpty()) {
                    int[] peek = queue.poll();
                    res[i++] = peek[0];

                    if (--peek[1] > 0) {
                        next.add(peek);
                    }
                }
            }

            queue.addAll(next);
        }
        
        return res;
    }
}
