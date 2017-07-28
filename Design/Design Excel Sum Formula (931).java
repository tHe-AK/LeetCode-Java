public class Excel {
    private int width;
    private int[][] cells;
    private Map<Integer, List<Integer>> forward;
    private Map<Integer, List<Integer>> backward;

    public Excel(int H, char W) {
        this.width = W - 'A' + 1;
        cells = new int[H][this.width];
        forward = new HashMap<>();
        backward = new HashMap<>();
    }

    public int get(int r, char c) {
        return cells[r - 1][c - 'A'];
    }

    public void set(int r, char c, int v) {
        int i = r - 1;
        int j = c - 'A';
        int idx = i * width + j;
        removeLinks(idx);
        updateValue(idx, v - cells[i][j]);
    }

    public int sum(int r, char c, String[] strs) {
        int i = r - 1;
        int j = c - 'A';
        int idx = i * width + j;
        removeLinks(idx);
        
        int sum = 0;
        
        for (String str : strs) {
            if (str.contains(":")) {
                String[] pair = str.split(":");
                int x1 = pair[0].charAt(1) - '1';
                int y1 = pair[0].charAt(0) - 'A';
                int x2 = pair[1].charAt(1) - '1';
                int y2 = pair[1].charAt(0) - 'A';
                
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        sum += cells[x][y];
                        addLinks(x * width + y, idx);
                    }
                }
            } else {
                int x = str.charAt(1) - '1';
                int y = str.charAt(0) - 'A';
                sum += cells[x][y];
                addLinks(x * width + y, idx);
            }
        }
        
        updateValue(idx, sum - cells[i][j]);
        
        return sum;
    }
    
    private void addLinks(int origin, int dest) {
        forward.putIfAbsent(origin, new ArrayList<>());
        forward.get(origin).add(dest);
        backward.putIfAbsent(dest, new ArrayList<>());
        backward.get(dest).add(origin);
    }
    
    private void removeLinks(int idx) {        
        if (backward.containsKey(idx)) {
            for (Integer key : backward.get(idx)) {
                List<Integer> list = forward.get(key);
                list.remove(Integer.valueOf(idx));
                
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
            int x = peek / width;
            int y = peek % width;
            cells[x][y] += diff;
            
            if (forward.containsKey(peek)) {
                for (Integer dest : forward.get(peek)) {
                    queue.offer(dest);
                }
            }
        }
    }
}
