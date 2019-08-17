class Excel {
    private int[][] cells;
    private Map<Integer, List<Integer>> forward;
    private Map<Integer, List<Integer>> backward;

    public Excel(int H, char W) {
        cells = new int[H][W - 'A' + 1];
        forward = new HashMap<>();
        backward = new HashMap<>();
    }
    
    public void set(int r, char c, int v) {
        int idx = getIdx(r, c);
        removeLinks(idx);
        updateValue(idx, v - cells[r - 1][c - 'A']);
    }
    
    public int get(int r, char c) {
        return cells[r - 1][c - 'A'];
    }
    
    public int sum(int r, char c, String[] strs) {
        int idx = getIdx(r, c);
        removeLinks(idx);
        int sum = 0;
        
        for (String str : strs) {
            if (str.contains(":")) {
                String[] pair = str.split(":");
                int x1 = Integer.parseInt(pair[0].substring(1)) - 1;
                int y1 = pair[0].charAt(0) - 'A';
                int x2 = Integer.parseInt(pair[1].substring(1)) - 1;
                int y2 = pair[1].charAt(0) - 'A';
                
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        sum += cells[x][y];
                        addLinks(x * cells[0].length + y, idx);
                    }
                }
            } else {
                int x = str.charAt(1) - '1';
                int y = str.charAt(0) - 'A';
                sum += cells[x][y];
                addLinks(x * cells[0].length + y, idx);
            }
        }
        
        updateValue(idx, sum - cells[r - 1][c - 'A']);
        return sum;
    }
    
    private int getIdx(int r, char c) {
        return (r - 1) * cells[0].length + c - 'A';
    }
    
    private void addLinks(int origin, int dest) {
        forward.putIfAbsent(origin, new ArrayList<>());
        forward.get(origin).add(dest);
        backward.putIfAbsent(dest, new ArrayList<>());
        backward.get(dest).add(origin);
    }
    
    private void removeLinks(Integer idx) {        
        if (backward.containsKey(idx)) {
            for (Integer key : backward.get(idx)) {
                List<Integer> list = forward.get(key);
                list.remove(idx);
                
                if (list.isEmpty()) {
                    forward.remove(key);
                }
            }
            
            backward.remove(idx);
        }
    }
    
    private void updateValue(int idx, int diff) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        
        while (!queue.isEmpty()) {
            int peek = queue.poll();
            int x = peek / cells[0].length;
            int y = peek % cells[0].length;
            cells[x][y] += diff;
            
            if (forward.containsKey(peek)) {
                for (Integer dest : forward.get(peek)) {
                    queue.offer(dest);
                }
            }
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */
