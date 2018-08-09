class Solution {
    private int[][] rects;
    private TreeMap<Integer, Integer> treeMap;
    private int sum;
    private Random rand;
    
    public Solution(int[][] rects) {
        this.rects = rects;
        treeMap = new TreeMap<>();
        sum = 0;
        rand = new Random();
        
        for (int i = 0; i < rects.length; i++) {
            treeMap.put(sum, i);
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }
    
    public int[] pick() {
        int num = rand.nextInt(sum);
        int key = treeMap.floorKey(num);
        int val = treeMap.get(key);
        int diff = num - key;
        int[] rect = rects[val];
        int len = rect[2] - rect[0] + 1;
        int x = rect[0] + diff % len;
        int y = rect[1] + diff / len;
        return new int[] { x, y };
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
