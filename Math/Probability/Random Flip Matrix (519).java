class Solution {
    private int n_rows;
    private int n_cols;
    private int count;
    private Map<Integer, Integer> map;
    private Random rand;

    public Solution(int n_rows, int n_cols) {
        this.n_rows = n_rows;
        this.n_cols = n_cols;
        count = n_rows * n_cols;
        map = new HashMap<>();
        rand = new Random();
    }
    
    public int[] flip() {
        int num = rand.nextInt(count--);
        int idx = map.getOrDefault(num, num);
        map.put(num, map.getOrDefault(count, count));
        int x = idx / n_cols;
        int y = idx % n_cols;
        return new int[] { x, y };
    }
    
    public void reset() {
        count = n_rows * n_cols;
        map.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
