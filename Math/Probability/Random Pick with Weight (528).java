class Solution {
    private TreeMap<Integer, Integer> treeMap;
    private int sum;
    private Random rand;
    
    public Solution(int[] w) {
        treeMap = new TreeMap<>();
        sum = 0;
        rand = new Random();
        
        for (int i = 0; i < w.length; i++) {
            treeMap.put(sum, i);
            sum += w[i];
        }
    }
    
    public int pickIndex() {
        int num = rand.nextInt(sum);
        int key = treeMap.floorKey(num);
        return treeMap.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
